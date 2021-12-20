package com.example.etask;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.etask.databinding.FragmentFormtaskBinding;
import com.example.etask.databinding.FragmentProfileBinding;
import com.example.etask.databinding.FragmentSendBinding;

public class ProfileFragment extends Fragment {
private FragmentProfileBinding binding;
private boolean darkMode=false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController controller= Navigation.findNavController(view);

        binding.buttonDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              controller.navigate(R.id.action_profileFragment_to_colorSelectFragment);
            }
        });
        binding.buttonDark.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
               if (darkMode){
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
               } else {
                   AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
               }
               darkMode=!darkMode;
            }
        });
    }


}