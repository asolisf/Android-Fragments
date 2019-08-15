package com.alansolisflores.fragments.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alansolisflores.fragments.Fragments.DataFragment;
import com.alansolisflores.fragments.Fragments.DetailsFragment;
import com.alansolisflores.fragments.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void SendData(String name){

        if(isMultiPanel()){
            DetailsFragment detailsFragment =
                    (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
            detailsFragment.GetData(name);
        }else {
            Intent intent = new Intent(this,DetailsActivity.class);
            intent.putExtra("text",name);
            startActivity(intent);
        }
    }

    private boolean isMultiPanel(){
        return (getSupportFragmentManager().findFragmentById(R.id.detailsTextView) != null);
    }
}
