package com.leo_escobar.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        RecyclerView petRecycler = (RecyclerView) findViewById(R.id.activity_main_pet_recycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        petRecycler.setLayoutManager(gridLayoutManager);

        ArrayList<Pet> petList = new ArrayList<>();

        petList.add(new Pet("Sia", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.sia));
        petList.add(new Pet("Pun", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.pun));
        petList.add(new Pet("Catrina", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.catrina));
        petList.add(new Pet("Husk", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.husk));
        petList.add(new Pet("Capitano", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.capitano));
        petList.add(new Pet("Noodles", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.noodles));
        petList.add(new Pet("Tut", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.tut));
        petList.add(new Pet("Pal", getString(R.string.pet_description), "Sandra", "555-55-55", R.drawable.pal));

        PetAdapter petAdapter = new PetAdapter(this, petList);
        petRecycler.setAdapter(petAdapter);
        petAdapter.setOnPetClickListener(new PetAdapter.OnPetClickListener() {
            @Override
            public void onPetClick(Pet pet) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.PET_KEY, pet);
                startActivity(intent);
    }
});
    }
}