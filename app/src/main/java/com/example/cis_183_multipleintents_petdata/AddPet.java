package com.example.cis_183_multipleintents_petdata;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddPet extends AppCompatActivity
{
    EditText ev_j_petName;
    EditText ev_j_petAge;
    EditText ev_j_petType;

    Button btn_j_goBack;
    Intent mainActivity;

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
        ev_j_petName = findViewById(R.id.et_v_petName);
        ev_j_petAge = findViewById(R.id.et_v_petAge);
        ev_j_petType = findViewById(R.id.et_v_petType);

        setOnButtonClickListener();
    }

    private void setOnButtonClickListener()
    {
        btn_j_goBack.setOnClickListener(new View.OnClickListener() {
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
       String name = ev_j_petName.getText().toString();
       String type = ev_j_petType.getText().toString();
       String ageText = ev_j_petAge.getText().toString();
       int age = 0;
       age = Integer.parseInt(ageText);
        //make a pet
        Pet p = new Pet();
        p.setName(name);
        p.setType(type);
        p.setAge(age);
        //send pet to main
        //add pet to list
        Intent goBack = new Intent(AddPet.this, MainActivity.class);
        goBack.putExtra("PetData", p);
        startActivity(goBack);
    }
}