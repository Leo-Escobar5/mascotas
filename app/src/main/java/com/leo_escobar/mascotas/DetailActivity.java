package com.leo_escobar.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailActivity extends AppCompatActivity {
    public static final String PET_KEY = "pet";

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.detail_activity_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // boton de retroseso de pagina en el toolbar
        toolbar.setNavigationOnClickListener(v -> finish());

        Bundle extras = getIntent().getExtras();
        final Pet pet = extras.getParcelable(PET_KEY);

        if (pet != null) {
            TextView petDescription = (TextView) findViewById(R.id.activity_detail_pet_description);
            TextView ownerName = (TextView) findViewById(R.id.activity_detail_owner_name);
            TextView ownerPhoneNumber = (TextView) findViewById(R.id.activity_detail_owner_phone_number);
            ImageView petImage = (ImageView) findViewById(R.id.activity_detail_pet_image);

            petDescription.setText(pet.getDescription());
            ownerName.setText(pet.getOwnerName());
            ownerPhoneNumber.setText(pet.getPhoneNumber());
            petImage.setImageDrawable(ContextCompat.getDrawable(this, pet.getImageId()));

            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.activity_detail_collapsing_toolbar);
            findViewById(R.id.activity_detail_collapsing_toolbar);
            collapsingToolbarLayout.setTitle(pet.getName());

        }
    }
}