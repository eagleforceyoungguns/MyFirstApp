package com.rich.myfirstapp;

import com.rich.myfirstapp.database.DatabaseHandler;
import com.rich.myfirstapp.database.Patient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PatientDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The person this fragment is presenting.
     */
    public Patient mItem;

    /**
     * The UI elements showing the details of the Person
     */
    public TextView textFirstName;
    public TextView textLastName;
    public TextView textReason;
    public TextView textHeight;
    public TextView textWeight;
    public TextView textBP;
    public TextView textTemp;
    public TextView textPulse;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PatientDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Should use the contentprovider here ideally
            mItem = DatabaseHandler.getInstance(getActivity()).getPatient(getArguments().getLong(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_patient_detail, container, false);

        if (mItem != null) {
            textFirstName = ((TextView) rootView.findViewById(R.id.textFirstName));
            textFirstName.setText(mItem.firstname);

            textLastName = ((TextView) rootView.findViewById(R.id.textLastName));
            textLastName.setText(mItem.lastname);
           
            textHeight = ((TextView) rootView.findViewById(R.id.textHeight));
            textHeight.setText(mItem.height);
            
            textWeight = ((TextView) rootView.findViewById(R.id.textWeight));
            textWeight.setText(mItem.weight);
            
            textBP = ((TextView) rootView.findViewById(R.id.textBP));
            textBP.setText(mItem.bp);
            
            textTemp = ((TextView) rootView.findViewById(R.id.textTemp));
            textTemp.setText(mItem.temp);
            
            textPulse = ((TextView) rootView.findViewById(R.id.textPulse));
            textPulse.setText(mItem.pulse);
            
            textReason = ((TextView) rootView.findViewById(R.id.textReason));
            textReason.setText(mItem.reason);
        }

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        updatePatientFromUI();
        
    }
    

    public void updatePatientFromUI() {
        if (mItem != null) {
            mItem.firstname = textFirstName.getText().toString();
            mItem.lastname = textLastName.getText().toString();
            mItem.height = textHeight.getText().toString();
            mItem.weight = textWeight.getText().toString();
            mItem.bp = textBP.getText().toString();
            mItem.temp = textTemp.getText().toString();
            mItem.pulse = textPulse.getText().toString();
            mItem.reason = textReason.getText().toString();
            

            DatabaseHandler.getInstance(getActivity()).putPatient(mItem);
            
        }
    }
}