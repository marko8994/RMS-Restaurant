package com.rms.markomladenovic.restoran.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rms.markomladenovic.restoran.Order;
import com.rms.markomladenovic.restoran.R;
import com.rms.markomladenovic.restoran.activities.SingleFragmentActivity;
import com.rms.markomladenovic.restoran.viewmodels.HomeFragmentViewModel;

public class OrderOverviewFragment extends Fragment {

    @SuppressWarnings("FieldCanBeLocal")
    private HomeFragmentViewModel viewModel;

    public static OrderOverviewFragment newInstance() {
        return new OrderOverviewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_overview, container, false);
        Order order = getArguments().getParcelable("order");
        TextView textViewOrderedFood = rootView.findViewById(R.id.textViewFoodOrder);
        TextView textViewOrderedDrinks = rootView.findViewById(R.id.textViewDrinkOrder);
        TextView textViewComment = rootView.findViewById(R.id.textViewExtraComment);
        TextView textViewDeliveryType = rootView.findViewById(R.id.textViewDeliveryType);
        Button buttonHome = rootView.findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();

                // Ako hoces na pocetni ekran iskomentarisi
//                startActivity(new Intent(getContext(), SingleFragmentActivity.class));
//                getActivity().finish();
            }
        });

        textViewOrderedFood.append(order.getFood());
        textViewOrderedDrinks.append(order.getDrink());
        textViewComment.append(order.getComment());
        textViewDeliveryType.append(order.getDeliveryType());
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(HomeFragmentViewModel.class);
    }

}
