package com.klarna.registry.controller;

import com.klarna.registry.domain.Person;
import com.klarna.registry.domain.Result;
import com.klarna.registry.validator.PersonValidator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class will handle the operations related to the personal registry.
 */
public class PersonRegistryController
{
    private final Map<String, Person> personRegistry;

    public PersonRegistryController()
    {
        personRegistry = new ConcurrentHashMap<>();
    }

    /**
     * Get the person by social security number.
     *
     * @param socialSecurityNumber of type String
     * @return of type Result
     */
    public Result<Person> retrievePersonBySSN(String socialSecurityNumber)
    {
        if (personRegistry.containsKey(socialSecurityNumber))
        {
            return new Result<>(Result.SUCCESS, "Successfully Retrieved the person.", personRegistry.get(socialSecurityNumber));
        }
        else
        {
            return new Result<>(Result.ERROR, "Person not found.");
        }

    }

    /**
     * Save a person object
     *
     * @param person of type Person
     * @return of type Result
     */
    public Result savePerson(Person person)
    {
        Result validaResult = PersonValidator.validatePerson(person);
        if (!validaResult.isSuccess())
        {
            return new Result<>(Result.ERROR, validaResult.getMessage());
        }
        if (personRegistry.containsKey(person.getSocialSecurityNumber()))
        {
            personRegistry.put(person.getSocialSecurityNumber(), person);
            return new Result<>(Result.SUCCESS, "Person updated successfully.");
        }
        else
        {
            personRegistry.put(person.getSocialSecurityNumber(), person);
            return new Result<>(Result.SUCCESS, "Person Created successfully.");
        }
    }

    /**
     * Get the oldest child name for the specified person by SSN
     * @param socialSecurityNumber of type String
     * @return of type Result
     */
    public Result<String> getOldestChildName(String socialSecurityNumber)
    {
        if (!personRegistry.containsKey(socialSecurityNumber))
        {
            return new Result<>(Result.ERROR, "Person not found for the given SSN.");
        }
        else
        {
            Person person = personRegistry.get(socialSecurityNumber);
            if (person.getChildren() != null && person.getChildren().size() > 0)
            {
                String childName = person.getChildren().entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                        .findFirst().get().getKey();
                return new Result<>(Result.SUCCESS, "Oldest Child Name found successfully.", childName);
            }
            else
            {
                return new Result<>(Result.ERROR, "No children found for the given Person.");
            }
        }
    }
}
