package com.klarna.registry.controller;

import com.klarna.registry.domain.Person;
import com.klarna.registry.domain.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PersonRegistryControllerTest
{

    private PersonRegistryController personRegistryController;

    @BeforeAll
    void setupData()
    {
        personRegistryController = new PersonRegistryController();

        Person person1 = new Person("12345", "Shane");
        person1.setSpouseName("Kim");
        Map<String, Integer> childerenMap1 = new HashMap<>();
        childerenMap1.put("Smith", 5);
        childerenMap1.put("Warner", 10);
        person1.setChildren(childerenMap1);
        personRegistryController.savePerson(person1);

        Person person3 = new Person("565767", "George");
        person3.setSpouseName("Sandy");
        Map<String, Integer> childrenMap3 = new HashMap<>();
        childrenMap3.put("Cook", 5);
        childrenMap3.put("Tomson", 5);
        person3.setChildren(childrenMap3);
        personRegistryController.savePerson(person3);

        Person person4 = new Person("67778", "Brian");
        personRegistryController.savePerson(person4);

    }

    @Test
    void savePerson()
    {
        Person person2 = new Person("24434", "Jason");
        person2.setSpouseName("Marry");
        Map<String, Integer> childrenMap2 = new HashMap<>();
        childrenMap2.put("Kasun", 5);
        person2.setChildren(childrenMap2);
        Assertions.assertTrue(personRegistryController.savePerson(person2).isSuccess());
    }

    @Test
    void retrievePersonBySSN()
    {
        Result<Person> personResult = personRegistryController.retrievePersonBySSN("565767");
        Assertions.assertNotNull(personResult.getOutput());
        Assertions.assertEquals("George", personResult.getOutput().getName());
    }

    @Test
    void retrievePersonBySSN_NotFound()
    {
        Result<Person> personResult = personRegistryController.retrievePersonBySSN("924434");
        Assertions.assertNull(personResult.getOutput());
        Assertions.assertFalse(personResult.isSuccess());
    }

    @Test
    void savePerson_AfterUpdateExistingClient()
    {
        Result<Person> personResult = personRegistryController.retrievePersonBySSN("12345");
        Assertions.assertEquals("Kim", personResult.getOutput().getSpouseName());

        //Update person
        Person person = personResult.getOutput();
        person.setSpouseName("Liza");
        Result<Person> updatedPersonResult = personRegistryController.savePerson(person);
        Assertions.assertEquals("Liza", personResult.getOutput().getSpouseName());
    }


    @Test
    void getOldestChildName()
    {
        Result<String> personResult = personRegistryController.getOldestChildName("12345");
        Assertions.assertEquals("Warner", personResult.getOutput());
    }

    @Test
    void getOldestChildName_No_Matching_Person()
    {
        Result<String> personResult = personRegistryController.getOldestChildName("4343535");
        Assertions.assertFalse(personResult.isSuccess());
    }

    @Test
    void getOldestChildName_No_Children()
    {
        Result<String> personResult = personRegistryController.getOldestChildName("67778");
        Assertions.assertFalse(personResult.isSuccess());
        Assertions.assertEquals("No children found for the given Person.", personResult.getMessage() );
    }
}