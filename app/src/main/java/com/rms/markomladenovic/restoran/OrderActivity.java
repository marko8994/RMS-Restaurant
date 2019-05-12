package com.rms.markomladenovic.restoran;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OrderActivity extends AppCompatActivity {

    public static final String food = "unique key 1";
    public static final String drink = "unique key 2";
    public static final String comment = "unique key 3";
    public static final String delivery = "unique key 4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final CheckBox checkBoxFoodOne = findViewById(R.id.checkBoxFirstFood);
        final CheckBox checkBoxFoodTwo = findViewById(R.id.checkBoxSecondFood);
        final CheckBox checkBoxDrinkOne = findViewById(R.id.checkBoxFirstDrink);
        final CheckBox checkBoxDrinkTwo = findViewById(R.id.checkBoxSecondDrink);
        final TextInputEditText textInputComment = findViewById(R.id.textInputComment);
        RadioGroup radioGroupDelivery = findViewById(R.id.radioGroupDelivery);
        final RadioButton radioButtonDelivery = findViewById(radioGroupDelivery.getCheckedRadioButtonId());
        Button orderButton = findViewById(R.id.buttonOrder);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderToOverview = new Intent(OrderActivity.this, OverviewActivity.class);
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
                String deliveryType = radioButtonDelivery.getText().toString();
                String commentText = textInputComment.getText().toString();
                orderToOverview.putExtra(food, foodOrder);
                orderToOverview.putExtra(drink, drinkOrder);
                orderToOverview.putExtra(comment, commentText);
                orderToOverview.putExtra(delivery, deliveryType);
                startActivity(orderToOverview);
            }
        });
    }

}