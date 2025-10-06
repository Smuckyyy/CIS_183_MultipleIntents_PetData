package com.example.cis_183_multipleintents_petdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddPet extends AppCompatActivity
{

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

        btn_j_goBack = findViewById(R.id.btn_v_goBack);

        Intent cameFrom = getIntent();

        setOnButtClickListener();
    }

    private void setOnButtClickListener()
    {
        btn_j_goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Pet p = new Pet("Abigail", 3, Pet.PetType.petAt(3));
                mainActivity.putExtra("PetData", p);
                startActivity(mainActivity);
            }
        });
    }

    private void getPetDataFromTextBoxes()
    {
        //get data from textboxes
        //make a pet
        //send pet to main
        //add pet to list

        //Fill in after finishing lecture
    }
}