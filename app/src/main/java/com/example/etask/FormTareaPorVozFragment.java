package com.example.etask;

import static android.app.Activity.RESULT_OK;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.etask.databinding.FragmentSecondBinding;
import com.example.etask.databinding.FragmentVoiceformtaskBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Locale;

public class FormTareaPorVozFragment extends Fragment {
    private FragmentVoiceformtaskBinding binding;




    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentVoiceformtaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.editTitleTextTitle.setEndIconOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iniciarEntradaVoz("titulo");

            }
        });
        binding.editTitleTextTitle.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()==0){
                    binding.editTitleTextTitle.getEditText().setError(getString(R.string.tituloMissing));
                } else {
                    binding.editTitleTextDescription.getEditText().setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

        binding.editTitleTextDescription.setEndIconOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iniciarEntradaVoz("description");
            }
        });

        binding.editTitleTextDescription.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()==0){
                    binding.editTitleTextDescription.getEditText().setError(getString(R.string.descripcionMissing));
                } else {
                    binding.editTitleTextDescription.getEditText().setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

        binding.editTitleTextInicio.setEndIconOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iniciarEntradaVoz("inicio");
            }
        });

        binding.editTitleTextInicio.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()==0){
                    binding.editTitleTextInicio.getEditText().setError(getString(R.string.startDateMissing));
                } else {
                    binding.editTitleTextInicio.getEditText().setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

        binding.editTitleTextFin.setEndIconOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                iniciarEntradaVoz("fin");
            }
        });
        binding.editTitleTextFin.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()==0){
                    binding.editTitleTextFin.getEditText().setError(getString(R.string.endDateMissing));
                } else {
                    binding.editTitleTextFin.getEditText().setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        } );

        binding.btnSendVoiceTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.editTitleTextTitle.getEditText().getText().toString().trim()
                        .equals("") && !binding.editTitleTextDescription.getEditText().toString().trim()
                        .equals("") && !binding.editTitleTextInicio.getEditText().getText().toString().trim()
                        .equals("")&& !binding.editTitleTextFin.getEditText().getText().toString().trim()
                        .equals("")){

                } else {
                    Toast.makeText(getContext(),getString(R.string.emptySpaces),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void iniciarEntradaVoz(String classVoice){
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Indica tus datos ahora");
        intent.putExtra("class",classVoice);
        try {
            startActivityForResult(intent,100);
        } catch (ActivityNotFoundException e){

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:{
                ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                binding.editTitleTextTitle.getEditText().setText(result.get(0));
            }
        }
    }
}
