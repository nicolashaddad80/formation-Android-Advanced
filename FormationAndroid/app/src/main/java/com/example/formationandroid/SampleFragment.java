package com.example.formationandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SampleFragment extends Fragment {

    private AnimalViewModel mAnimalViewModel;
    private Button mAddBtn;
    public SampleFragment() {
        // Required empty public constructor
        super(R.layout.fragment_sample);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAnimalViewModel = new ViewModelProvider(requireActivity()).get(AnimalViewModel.class);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAddBtn = view.findViewById(R.id.addButton);
        mAddBtn.setOnClickListener(v ->requireActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment2, AnimalListFragment.class,null)
                .commit());
    }
}
