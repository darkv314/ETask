package com.example.etask;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.etask.databinding.FragmentSecondBinding;
import com.example.etask.databinding.FragmentTaskDetailsBinding;

public class TaskDescriptionFragment extends Fragment {
    private FragmentTaskDetailsBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTaskDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController controller= Navigation.findNavController(view);
        binding.btnDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.action_taskDescriptionFragment_to_confirmEraseFragment);
            }
        });
        binding.btnShareTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.action_taskDescriptionFragment_to_fragmentSendApp);
            }
        });
    }
}
