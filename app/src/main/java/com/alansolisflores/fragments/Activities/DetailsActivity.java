package com.alansolisflores.fragments.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alansolisflores.fragments.Fragments.DetailsFragment;
import com.alansolisflores.fragments.R;

public class DetailsActivity extends AppCompatActivity {

    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getIntent().getExtras() != null){
            this.name = getIntent().getStringExtra("text");
        }

        DetailsFragment detailsFragment =
                (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        detailsFragment.GetData(name);
    }
}
