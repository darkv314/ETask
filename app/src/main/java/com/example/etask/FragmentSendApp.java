package com.example.etask;

import android.app.Application;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.etask.databinding.FragmentSendBinding;

public class FragmentSendApp extends Fragment {
    private FragmentSendBinding binding;
    private final static String[] Users=new String[]{
            "Nickquoland","NickyNick","NickySmalls","Biggie","Bernie","Andres","Andro77","Nicole"
    };

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSendBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Check this new task the user had made in ETask");
                intent.putExtra(Intent.EXTRA_TEXT,"www.etask.com");
                startActivity(Intent.createChooser(intent,getString(R.string.shareVia)));
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,Users);
        binding.searcher.setAdapter(adapter);
    }
}
