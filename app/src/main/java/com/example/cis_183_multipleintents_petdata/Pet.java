package com.example.cis_183_multipleintents_petdata;

import java.util.ArrayList;
import java.util.Arrays;

public class Pet
{
    //A pet is comprised of the following information
    //name, age, and type

    private String name;
    private int age;
    private String type;


    //Default Constructor
    //Called when we make a new pet object
    public Pet()
    {

    }

    //Overloaded Constructor, remember this?
    //Called when we make a new pet object and we pass data for the given pet
    public Pet(String n, int a, String t)
    {
        name = n;
        age = a;
        type = t;
    }

    //***To have android studio make getters and setters, right click, generate, and ctrl+click all variables you want to be getters and setters***

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    //This is static because we don't want to overwrite data everytime we type "new"
    //If you have a static class, then every function within it also needs to be static
    static class PetType
    {
        static ArrayList<String> typeofPet = new ArrayList<>(Arrays.asList("Dog", "Cat", "Snake", "Chicken", "Hamster"));

        public static String petAt(int i)
        {
            return typeofPet.get(i);
        }

        public static ArrayList<String> getAllPetTypes()
        {
            return typeofPet;
        }

        //This function below is an ADD function
        public static void addPet(String t)
        {
            typeofPet.add(t);
        }
    }
}
