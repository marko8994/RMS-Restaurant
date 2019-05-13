package com.rms.markomladenovic.restoran.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.rms.markomladenovic.restoran.R;

public class SingleFragmentActivityViewModel extends ViewModel {

    public void replaceFragment(FragmentActivity activity, Fragment fragmentToBeReplaced) {
        activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left,
                        R.anim.slide_out_right, R.anim.slide_in_right)
                .replace(R.id.container, fragmentToBeReplaced)
                .addToBackStack(fragmentToBeReplaced.getClass().getName())
                .commit();
    }

    public void replaceFragmentWithClearBack(FragmentActivity activity, Fragment fragmentToBeReplaced) {
        activity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left,
                        R.anim.slide_out_right, R.anim.slide_in_right)
                .replace(R.id.container, fragmentToBeReplaced)
                .addToBackStack(fragmentToBeReplaced.getClass().getName())
                .commit();
    }

    public void replaceFragmentWithoutAnimation(FragmentActivity activity,
                                                Fragment fragmentToBeReplaced) {
        activity.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmentToBeReplaced)
                .addToBackStack(fragmentToBeReplaced.getClass().getName())
                .commit();
    }

}
