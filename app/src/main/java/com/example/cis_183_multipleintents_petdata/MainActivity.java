package com.example.cis_183_multipleintents_petdata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

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
    static private ArrayList<Pet> listOfPets;
    static int numberTestingLoad = 50;
    static boolean firstLoad = true;

    //This is going to be used for testing purposes only
    //Just to show on listview interact well with arrays***

    String[] test = {"Hello","hi","hola"};
    ListView lv_j_listOfPets;
    PetListAdapter plAdapter;
    Button btn_j_addPet;
    Intent intent_j_displayUpdate;
    Intent AddPet;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ConstraintLayout), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent cameFrom = getIntent();

        if(cameFrom.getSerializableExtra("PetData") != null)
        {
            //Fix this during lecture
            //Pet petData = cameFrom.getSerializableExtra("petData");
            //listOfPets.add(petData);
        }
        else
        {
            listOfPets = new ArrayList<>();
            Pet pet = new Pet();
            //This creates a pet using the default constructor
            pet.setName("Tito");
            pet.setAge(12);
            pet.setType("Dog");
            //Add the new pet to our list
            listOfPets.add(pet);
            //Using an overloaded constructor, this is how you can easily add new pets/information
            Pet anotherPet = new Pet("Willow", 5, "Dog");
            addDummyDataToArrayList();

            firstLoad = false;
        }

        //AddPet Button
        AddPet = new Intent(MainActivity.this, AddPet.class);

        //GUI Connection
        lv_j_listOfPets = findViewById(R.id.lv_v_listOfPets);

        btn_j_addPet = findViewById(R.id.btn_v_addPet);

        //Get an instance of PetDisplayUpdate
        //New intents always ask for where you are now (in this case MainActivity and then where you want to go (.class)
        intent_j_displayUpdate = new Intent(MainActivity.this, PetDisplayUpdate.class);

        //We need an adapter to be used with the listview
        //If the cells (boxes in a listview) require more than one string being displayed
        //Different color, different color text, etc.
        //You MUST create your own custom adapter

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, test );
        //lv_j_listOfPets.setAdapter(adapter);
            //^Context means where am I coming from (this means THIS specific class or .java file

        //We do not want this instead; we want to touch code as little as possible, we do not want to add pets using the code everytime, instead using xml and gui for UX (User Experience)
        //Pet pet2;

        //Any log.d messages are shown inside of Logcat
        //Use this to your advantage to see how things are working in the background
        //If classes arent imported just right click and import them, no worries
        //Log.d("Pet Data: ", pet.getName() + " is a " + pet.getType() + " and is " + pet.getAge() + " years old.");

        //Call functions here
        displayAllPetData();
        fillListView();
        setOnClickListenerForListView();
        setOnButtClickListener();

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
        newPet = new Pet("Meowth", 3, Pet.PetType.petAt(1));
        listOfPets.add(newPet);
        newPet = new Pet("Whiskers", 9, Pet.PetType.petAt(1));
        listOfPets.add(newPet);

    }

    private void displayAllPetData()
    {
        for(int i = 0; i < listOfPets.size(); i++)
        {
            Log.d("Pet Info", listOfPets.get(i).getName());
        }
    }

    private void fillListView()
    {
        plAdapter = new PetListAdapter(this, listOfPets);
        lv_j_listOfPets.setAdapter(plAdapter);
    }

    private void setOnClickListenerForListView()
    {
        lv_j_listOfPets.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Pet petSelected = listOfPets.get(position);
                goToPetDisplayUpdate(petSelected);
                //Testing purposes
                //Log.d("Pet Selected: ", petSelected.getName());
            }
        });
    }

    private void setOnButtClickListener()
    {
        btn_j_addPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(AddPet);
                //Missing data here


            }
        });
    }

    public void goToPetDisplayUpdate(Pet pet)
    {
        intent_j_displayUpdate.putExtra("PetData", pet);
        startActivity(intent_j_displayUpdate);
    }

    public void addPet(Pet p)
    {
        //Missing data here
    }
}