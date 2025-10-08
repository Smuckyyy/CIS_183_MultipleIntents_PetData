package com.example.cis_183_multipleintents_petdata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddPet extends AppCompatActivity
{
    EditText ev_j_petName;
    EditText ev_j_petAge;
    Spinner sp_j_petType;
    TextView tv_j_addType;

    Button btn_j_goBack;
    Button btn_j_add_addPet;
    //We can use an array adapter for the spinner
    ArrayAdapter<String> adapter;

    Intent mainActivity;
    Intent intent_j_addPetType;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_pet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //This is code to get info passed from mainactivity.java
        //get the intent that called me
        Intent cameFrom = getIntent();
        //get the bundle that was passed to me from "cameFrom" intent
        Bundle infoPassedToMe = cameFrom.getExtras();

        //we do not know if infoPassedToMe will have any data
        //because we do not know who loaded this intent.
        if(infoPassedToMe != null)
        {
            String data = infoPassedToMe.getString("InfoPassed");
            Log.d("INFO PASSED FROM MAIN: ", data);
        }

        btn_j_goBack = findViewById(R.id.btn_v_goBack);
        btn_j_add_addPet = findViewById(R.id.btn_v_add_addPet);
        ev_j_petName = findViewById(R.id.et_v_petName);
        ev_j_petAge = findViewById(R.id.et_v_petAge);
        sp_j_petType = findViewById(R.id.sp_v_petType);
        tv_j_addType = findViewById(R.id.tv_v_addType);

        mainActivity = new Intent(AddPet.this, MainActivity.class);
        intent_j_addPetType = new Intent(AddPet.this, AddPetType.class);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Pet.PetType.getAllPetTypes());
        sp_j_petType.setAdapter(adapter);

        setOnButtonClickListener();
        addButtonClickListener();
        addNewTypeEventListener();
    }

    private void setOnButtonClickListener()
    {
        btn_j_goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //getPetDataFromTextBoxes();
                startActivity(mainActivity);
            }
        });
    }

    private void addButtonClickListener()
    {
        btn_j_add_addPet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                getPetDataFromTextBoxes();
            }
        });
    }

    private void getPetDataFromTextBoxes()
    {
        //get data from textboxes
//       String name = ev_j_petName.getText().toString();
//       //String type = ev_j_petType.getText().toString();
//       String ageText = ev_j_petAge.getText().toString();
//       int age = 0;
//       age = Integer.parseInt(ageText);
//        //make a pet
//        Pet p = new Pet();
//        p.setName(name);
//        //p.setType(type);
//        p.setAge(age);
//        //send pet to main
//        //add pet to list
//        Intent goBack = new Intent(AddPet.this, MainActivity.class);
//        goBack.putExtra("PetData", p);
//        startActivity(goBack);

        Pet p = new Pet();
        p.setName(ev_j_petName.getText().toString());
        p.setType(sp_j_petType.getSelectedItem().toString());
        p.setAge(Integer.parseInt(ev_j_petAge.getText().toString()));

        mainActivity.putExtra("PetData", p);
        startActivity(mainActivity);
    }

    private void addNewTypeEventListener()
    {
        startActivity(intent_j_addPetType);
    }
}