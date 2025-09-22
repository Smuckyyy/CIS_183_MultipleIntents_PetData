package com.example.cis_183_multipleintents_petdata;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //Anything that needs to be declared throughout the entire java class
    //needs to be below MainActivity and above OnCreate
    ArrayList<Pet> listOfPets;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //I also need a list to house all pets for the vet clinic
        ArrayList<Pet> listOfPets = new ArrayList<>();

        //This makes a chunk of data using the class file, having a name, age and type
        Pet pet = new Pet();
        //This creates a pet using the setters and getters
        pet.setName("Tito");
        pet.setAge(12);
        pet.setType("Dog");

        //Using an overloaded constructor, this is how you can easily add new pets/information
        Pet anotherPet = new Pet("Willow", 5, "Dog");

        //We do not want this; we want to touch code as little as possible, we do not want to add pets using the code everytime, instead using xml and gui for UX (User Experience)
        Pet pet2;

        //Any log.d messages are shown inside of Logcat
        //Use this to your advantage to see how things are working in the background
        //If classes arent imported just right click and import them, no worries
        Log.d("Pet Data: ", pet.getName() + " is a " + pet.getType() + " and is " + pet.getAge() + " years old.");
    }

    private void addDummyDataToArrayList()
    {
        //Create a new pet object
        //Fill in all pet information
        //Add that pet to the array list

        //Pet.set doesn't work because it would have to have the keyword new
        //Pet.PetType works because it is static, and it will load between intents/screens
        Pet newPet = new Pet("Tito", 7, Pet.PetType.petAt(0));
        listOfPets.add(newPet);
        newPet = new Pet("Willow", 3, Pet.PetType.petAt(1));
        listOfPets.add(newPet);
        newPet = new Pet("Whiskers", 9, Pet.PetType.petAt(1));
        listOfPets.add(newPet);
    }
}