package com.example.lbsapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.lbsapplication.databinding.FragmentSecondBinding;
import com.google.android.material.textfield.TextInputLayout;

import org.osmdroid.views.MapView;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    ViewPager2 viewPager;
    private MapView map = null;
    private TextInputLayout textInputEnd;
    private TextInputLayout textInputStart;
    private TextInputLayout textInputTime;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInputStart = getActivity().findViewById(R.id.textField1);
                textInputTime = getActivity().findViewById(R.id.textField2);
                textInputEnd = getActivity().findViewById(R.id.textField3);
                String input = "Start location: " + textInputStart.getEditText().getText().toString().trim();
                input += "\n";
                input += "Start time: " + textInputTime.getEditText().getText().toString().trim();
                input += "\n";
                input += "End location: " + textInputEnd.getEditText().getText().toString().trim();
                Toast.makeText(getContext(), input, Toast.LENGTH_SHORT).show();


                viewPager = (ViewPager2) getActivity().findViewById(R.id.view_pager);
                viewPager.setCurrentItem(0);



            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}