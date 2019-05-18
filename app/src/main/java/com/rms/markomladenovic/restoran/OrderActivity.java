package com.rms.markomladenovic.restoran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    private CheckBox checkBoxFoodOne;
    private CheckBox checkBoxFoodTwo;
    private CheckBox checkBoxDrinkOne;
    private CheckBox checkBoxDrinkTwo;
    private TextView editTextComment;
    private RadioGroup radioGroupDelivery;

    public static final String bundle_extra = "com.rms.markomladenovic.restoran.order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Initialize variables for screen components
        checkBoxFoodOne = findViewById(R.id.checkBoxFirstFood);
        checkBoxFoodTwo = findViewById(R.id.checkBoxSecondFood);
        checkBoxDrinkOne = findViewById(R.id.checkBoxFirstDrink);
        checkBoxDrinkTwo = findViewById(R.id.checkBoxSecondDrink);
        editTextComment = findViewById(R.id.editTextComment);
        radioGroupDelivery = findViewById(R.id.radioGroupDelivery);

        // Set onClickListener on order button
        Button buttonOrder = findViewById(R.id.buttonOrder);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderToOverview = new Intent(OrderActivity.this, OverviewActivity.class);
                Bundle bundleExtra = new Bundle();
                bundleExtra.putParcelable(bundle_extra, createOrder());
                orderToOverview.putExtras(bundleExtra);
                startActivity(orderToOverview);
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
        RadioButton radioButtonDelivery = findViewById(radioGroupDelivery.getCheckedRadioButtonId());
        String deliveryType = radioButtonDelivery.getText().toString();
        order.setFood(foodOrder);
        order.setDrink(drinkOrder);
        order.setComment(editTextComment.getText().toString());
        order.setDeliveryType(deliveryType);
        return order;
    }

}