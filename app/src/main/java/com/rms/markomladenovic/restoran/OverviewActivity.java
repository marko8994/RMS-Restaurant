package com.rms.markomladenovic.restoran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        Intent thirdScreen = getIntent();
        final String foodOrder = thirdScreen.getStringExtra(OrderActivity.food);
        final String drinkOrder = thirdScreen.getStringExtra(OrderActivity.drink);
        final String extraComment = thirdScreen.getStringExtra(OrderActivity.comment);
        final String deliveryType = thirdScreen.getStringExtra(OrderActivity.delivery);
        TextView textViewOrderedFood = findViewById(R.id.textViewFoodOrder);
        TextView textViewOrderedDrinks = findViewById(R.id.textViewDrinkOrder);
        TextView textViewComment = findViewById(R.id.textViewExtraComment);
        TextView textViewDeliveryType = findViewById(R.id.textViewDeliveryType);
        textViewOrderedFood.append(foodOrder);
        textViewOrderedDrinks.append(drinkOrder);
        //textViewOrderedFood.setText(getString(R.string.textView_prefixFood) +  foodOrder);
        //textViewOrderedDrinks.setText(getString(R.string.textView_prefixDrink) + drinkOrder);
        textViewComment.append(extraComment);
        textViewDeliveryType.append(deliveryType);
        Button buttonToHome = findViewById(R.id.buttonHome);
        buttonToHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(OverviewActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
    }
}
