package com.rms.markomladenovic.restoran;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.rms.markomladenovic.restoran.OrderActivity.bundle_extra;

public class OverviewActivity extends AppCompatActivity {

    private TextView textViewOrderedFood;
    private TextView textViewOrderedDrinks;
    private TextView textViewComment;
    private TextView textViewDeliveryType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        // Initializer variables for screen components
        textViewOrderedFood = findViewById(R.id.textViewFoodOrder);
        textViewOrderedDrinks = findViewById(R.id.textViewDrinkOrder);
        textViewComment = findViewById(R.id.textViewExtraComment);
        textViewDeliveryType = findViewById(R.id.textViewDeliveryType);

        fillTextViews();

        // Set onClickListener for home button
        Button buttonToHome = findViewById(R.id.buttonHome);
        buttonToHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(OverviewActivity.this, HomeActivity.class);
                startActivity(toHome);
            }
        });
    }

    private void fillTextViews() {
        // Initialize received order
        Order order = getIntent().getExtras().getParcelable(bundle_extra);

        if (order !=null) {
            String foodOrder = getString(R.string.textView_prefixFood) + " ";
            if (!order.getFood().matches("")) {
                foodOrder+= order.getFood();
            } else {
                foodOrder+=  getString(R.string.text_view_no_ordered_food);
            }
            textViewOrderedFood.setText(foodOrder);

            String drinkOrder = getString(R.string.textView_prefixDrink) + " ";
            if (!order.getDrink().matches("")) {
                drinkOrder+= order.getDrink();
            } else {
                drinkOrder+= getString(R.string.text_view_no_ordered_drink);
            }
            textViewOrderedDrinks.setText(drinkOrder);

            String comment = getString(R.string.textView_prefixExtraComment) + " ";
            if (!order.getComment().matches("")) {
                comment+= order.getComment();
            } else {
                comment+= getString(R.string.text_view_no_extra_comment);
            }

            textViewComment.setText(comment);
            String deliveryType = getString(R.string.textView_deliveryType) + ": " + order.getDeliveryType();
            textViewDeliveryType.setText(deliveryType);
        } 
    }
}
