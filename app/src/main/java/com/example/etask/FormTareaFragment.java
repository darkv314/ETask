package com.example.etask;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.etask.databinding.FragmentFormtaskBinding;
import com.example.etask.databinding.FragmentVoiceformtaskBinding;

import java.util.Calendar;

public class FormTareaFragment extends Fragment {
    private FragmentFormtaskBinding binding;
    private DatePickerDialog dialog1;
    private DatePickerDialog dialog2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= FragmentFormtaskBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
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


                DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        i1=i1+1;
                        binding.editTitleTextInicio.getEditText().setText(i2+"/"+i1+"/"+i);
                    }
                },year,month,day);
                datePickerDialog.show();
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


               DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                       i1=i1+1;
                       binding.editTitleTextFin.getEditText().setText(i2+"/"+i1+"/"+i);
                   }
               },year,month,day);
               datePickerDialog.show();
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
        binding.photoClickView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    pickImageFromGalery();
                }
            }
        });
    }

    private void pickImageFromGalery(){
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==RESULT_OK){
          binding.photoClickView.setImageURI(data.getData());
          binding.imageIcon.setVisibility(View.INVISIBLE);
          binding.textPhotoAdd.setVisibility(View.INVISIBLE);
        }
    }
}
