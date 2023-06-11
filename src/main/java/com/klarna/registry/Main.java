package com.klarna.registry;

import com.klarna.registry.controller.PersonRegistryController;
import com.klarna.registry.domain.Person;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        PersonRegistryController personRegistryController = new PersonRegistryController();

        Person person1 = new Person("12345", "Shane");
        person1.setSpouseName("Liza");
        Map<String, Integer> childerenMap1 = new HashMap<>();
        childerenMap1.put("Kasun", 5);
        childerenMap1.put("Kamal", 10);
        person1.setChildren(childerenMap1);
        System.out.println(personRegistryController.savePerson(person1));

        Person person2 = new Person("24434", "Jason");
        person2.setSpouseName("Marry");
        Map<String, Integer> childrenMap2 = new HashMap<>();
        childrenMap2.put("Kasun", 5);
        person2.setChildren(childrenMap2);
        System.out.println(personRegistryController.savePerson(person2));

        Person person3 = new Person("565767", "Perera");
        person3.setSpouseName("Sandy");
        Map<String, Integer> childrenMap3 = new HashMap<>();
        childrenMap3.put("Cook", 5);
        childrenMap3.put("Tomson", 5);
        person3.setChildren(childrenMap3);
        System.out.println(personRegistryController.savePerson(person3));

        Person person4 = new Person("56345767", "Diana");
        System.out.println(personRegistryController.savePerson(person4));

        System.out.println(personRegistryController.retrievePersonBySSN("24434"));

        System.out.println(personRegistryController.retrievePersonBySSN("465657")); // invalid SSN

        System.out.println(personRegistryController.getOldestChildName("12345"));

        System.out.println(personRegistryController.getOldestChildName("56345767"));

        System.out.println(personRegistryController.getOldestChildName("565767"));

    }
}