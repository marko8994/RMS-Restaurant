package com.rms.markomladenovic.restoran.viewmodels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.rms.markomladenovic.restoran.fragments.OrderFragment;

public class HomeFragmentViewModel extends ViewModel {

    public View.OnClickListener goToOrderView(final FragmentActivity activity) {
        final SingleFragmentActivityViewModel activityViewModel =
                ViewModelProviders.of(activity).get(SingleFragmentActivityViewModel.class);
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                activityViewModel.replaceFragment(activity, OrderFragment.newInstance());
            }
        };
    }

    public View.OnClickListener openLogoImage(final Context context) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent link = new Intent();
                link.setAction(Intent.ACTION_VIEW);
                link.addCategory(Intent.CATEGORY_BROWSABLE);
                link.setData(Uri.parse("https://www.tripadvisor.rs/Restaurants-g294472-Belgrade.html"));
                context.startActivity(link);
            }
        };
    }
}
