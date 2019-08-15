package com.alansolisflores.fragments.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.alansolisflores.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment implements View.OnClickListener {

    private EditText nameEditText;
    private Button sendButton;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback = (DataListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must be DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data,container,false);
        // Inflate the layout for this fragment

        this.nameEditText = view.findViewById(R.id.nameEditText);
        this.sendButton = view.findViewById(R.id.sendButton);
        this.sendButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        String name = this.nameEditText.getText().toString().trim();
        if(!name.isEmpty()){
            callback.SendData(name);
        }
    }

    public interface DataListener{
        void SendData(String name);
    }
}
