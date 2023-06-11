package com.klarna.registry.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Person implements Serializable
{
    private static final long serialVersionUID=1L;
    private String socialSecurityNumber;
    private String name;
    private String spouseName;
    private Map<String, Integer> children;

    public Person(String socialSecurityNumber, String name)
    {
        this.socialSecurityNumber = socialSecurityNumber;
        this.name = name;
    }

    public String getSocialSecurityNumber()
    {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber)
    {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSpouseName()
    {
        return spouseName;
    }

    public void setSpouseName(String spouseName)
    {
        this.spouseName = spouseName;
    }

    public Map<String, Integer> getChildren()
    {
        return children;
    }

    public void setChildren(Map<String, Integer> children)
    {
        this.children = children;
    }
    @Override
    public String toString()
    {
        return "Person{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", name='" + name + '\'' +
                ", spouseName='" + spouseName + '\'' +
                ", children=" + children +
                '}';
    }
}
