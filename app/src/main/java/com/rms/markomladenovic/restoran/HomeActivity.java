package com.rms.markomladenovic.restoran;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button orderButton = findViewById(R.id.buttonHomeOrder);
        orderButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent homeToOrder = new Intent(HomeActivity.this, OrderActivity.class);
                startActivity(homeToOrder);
            }
        });

        ImageView imageLogo = findViewById(R.id.imageViewLogo);
        imageLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link = new Intent();
                link.setAction(Intent.ACTION_VIEW);
                link.addCategory(Intent.CATEGORY_BROWSABLE);
                link.setData(Uri.parse(getString(R.string.uri_restaurant_page)));
                startActivity(link);
            }
        });
    }
}
