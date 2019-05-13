package com.rms.markomladenovic.restoran.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rms.markomladenovic.restoran.Order;
import com.rms.markomladenovic.restoran.R;
import com.rms.markomladenovic.restoran.viewmodels.SingleFragmentActivityViewModel;

public class OrderFragment extends Fragment {

    private SingleFragmentActivityViewModel viewModel;
    private CheckBox checkBoxFoodOne;
    private CheckBox checkBoxFoodTwo;
    private CheckBox checkBoxDrinkOne;
    private CheckBox checkBoxDrinkTwo;
    private TextInputEditText textInputComment;
    private RadioGroup radioGroupDelivery;
    private View rootView;
    private Button buttonOrder;

    public static OrderFragment newInstance() {
        return new OrderFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_order, container, false);
        checkBoxFoodOne = rootView.findViewById(R.id.checkBoxFirstFood);
        checkBoxFoodTwo = rootView.findViewById(R.id.checkBoxSecondFood);
        checkBoxDrinkOne = rootView.findViewById(R.id.checkBoxFirstDrink);
        checkBoxDrinkTwo = rootView.findViewById(R.id.checkBoxSecondDrink);
        textInputComment = rootView.findViewById(R.id.textInputComment);
        radioGroupDelivery = rootView.findViewById(R.id.radioGroupDelivery);
        buttonOrder = rootView.findViewById(R.id.buttonOrder);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SingleFragmentActivityViewModel.class);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = OrderOverviewFragment.newInstance();
                Bundle bundleExtra = new Bundle();
                bundleExtra.putParcelable("order", createOrder());
                fragment.setArguments(bundleExtra);
                viewModel.replaceFragment(getActivity(), fragment);
            }
        });
    }

    private Order createOrder() {
        Order order = new Order();
        String foodOrder = "";
        String drinkOrder = "";
        if (checkBoxFoodOne.isChecked()) {
            String foodOne = checkBoxFoodOne.getText().toString();
            foodOrder += foodOne + ",";
        }
        if (checkBoxFoodTwo.isChecked()) {
            String foodTwo = checkBoxFoodTwo.getText().toString();
            foodOrder += foodTwo;
        }
        if (checkBoxDrinkOne.isChecked()) {
            String drinkOne = checkBoxDrinkOne.getText().toString();
            drinkOrder += drinkOne + ",";
        }
        if (checkBoxDrinkTwo.isChecked()) {
            String drinkTwo = checkBoxDrinkTwo.getText().toString();
            drinkOrder += drinkTwo;
        }
        RadioButton radioButtonDelivery = rootView.findViewById(radioGroupDelivery
                .getCheckedRadioButtonId());
        String deliveryType = radioButtonDelivery.getText().toString();
        order.setFood(foodOrder);
        order.setDrink(drinkOrder);
        order.setComment(textInputComment.getText().toString());
        order.setDeliveryType(deliveryType);
        return order;
    }

}
