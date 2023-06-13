package com.klarna.registry.validator;

import com.klarna.registry.domain.Person;
import com.klarna.registry.domain.Result;

public class PersonValidator
{
    /**
     * Validate the Person entity
     * @param person of type Person
     * @return of tyep Result
     */
    public static Result validatePerson(Person person)
    {
        if (person.getSocialSecurityNumber() == null || person.getSocialSecurityNumber().isEmpty())
        {
            return new Result( Result.ERROR, "Person Social security number mandatory.");
        }

        return new Result( Result.SUCCESS, "Validation success.");
    }
}
