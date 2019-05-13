package com.rms.markomladenovic.restoran.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rms.markomladenovic.restoran.R;
import com.rms.markomladenovic.restoran.fragments.HomeFragment;
import com.rms.markomladenovic.restoran.viewmodels.SingleFragmentActivityViewModel;

public class SingleFragmentActivity extends AppCompatActivity {

    @SuppressWarnings("FieldCanBeLocal")
    private SingleFragmentActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SingleFragmentActivityViewModel.class);
        setContentView(R.layout.activity_single_fragment);
        if (savedInstanceState == null) {
            viewModel.replaceFragmentWithoutAnimation(this, HomeFragment.newInstance());
        }
    }
}
