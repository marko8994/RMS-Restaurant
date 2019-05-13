package com.rms.markomladenovic.restoran.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.rms.markomladenovic.restoran.R;
import com.rms.markomladenovic.restoran.viewmodels.HomeFragmentViewModel;

public class HomeFragment extends Fragment {

    @SuppressWarnings("FieldCanBeLocal")
    private HomeFragmentViewModel viewModel;
    private Button orderButton;
    private ImageView imageLogo;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        orderButton = rootView.findViewById(R.id.buttonHomeOrder);
        imageLogo = rootView.findViewById(R.id.logo);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
        imageLogo.setOnClickListener(viewModel.openLogoImage(getContext()));
        orderButton.setOnClickListener(viewModel.goToOrderView(getActivity()));
    }

}
