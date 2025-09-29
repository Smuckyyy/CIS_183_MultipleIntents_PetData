package com.example.cis_183_multipleintents_petdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PetListAdapter extends BaseAdapter
    //This base adapter can be implemented by right clicking above the class and hitting implement. Add all
{
    Context context;
    ArrayList<Pet> listOfPets;

    public PetListAdapter(Context c, ArrayList<Pet> ls)
    {
        context = c;
        listOfPets = ls;
    }

    @Override
    public int getCount()
    {
        //This figures out how many cells (listview) there are
        return listOfPets.size();
    }

    @Override
    public Object getItem(int position)
    {
        //Gets the pet
        return listOfPets.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        //Gets the number of whatever pet is in which spot ex. 0 = Dog
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        //This all handles the GUI of the cells (listview)
        if(view == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.pet_cell, null);
        }

        //Find the GUI elements in our custom cell
        TextView petName = view.findViewById(R.id.tv_v_cell_name);
        TextView petType = view.findViewById(R.id.tv_v_cell_type);
        TextView petAge = view.findViewById(R.id.tv_v_cell_age);

        //Get data for this pet from the listOfPets
        //We can access different elements based off
        //the position value that is passed to this function
        Pet pet = listOfPets.get(position);

        //Set the GUI for the custom cell
        petName.setText(pet.getName());
        petType.setText(pet.getType());
        petAge.setText(Integer.toString(pet.getAge()));

        return view;
    }
}
