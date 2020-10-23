package com.example.handmadewithlove;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AdminAddNewProduct extends AppCompatActivity {
    private String categoryName, Description, Pname, Price, saveCurrentDate, saveCurrentTime, productRandomKey;
    private ImageView InputProductImage;
    private Button AddNewProductButton;
    private EditText InputProductName, InputProductDescription, InputProductPrice;
    private  static final int gallerypic = 1;
    private Uri ImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_product);

        categoryName = getIntent().getExtras().get("category").toString();
        Toast.makeText(this, categoryName, Toast.LENGTH_SHORT).show();

        AddNewProductButton = (Button) findViewById(R.id.add_new_product);
        InputProductName = (EditText) findViewById(R.id.product_name);
        InputProductDescription = (EditText) findViewById(R.id.product_description);
        InputProductPrice = (EditText) findViewById(R.id.product_price);
        InputProductImage = (ImageView) findViewById(R.id.select_product_image);

        InputProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        AddNewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateProductData();
            }
        });

    }

    private void ValidateProductData() {
        Description = InputProductDescription.getText().toString();
        Pname = InputProductName.getText().toString();
        Price = InputProductPrice.getText().toString();


        if (ImageUri == null){
            Toast.makeText(this, "Need to select Image", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Description)){
            Toast.makeText(this, "Please enter Description", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Pname)){
            Toast.makeText(this, "Please enter Product Name", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Price)){
            Toast.makeText(this, "Please enter Price", Toast.LENGTH_SHORT).show();
        }
        else {
            StoreProductInformation();
        }
    }

    private void StoreProductInformation() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;

    }

    private void openGallery() {
        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, gallerypic);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == gallerypic && requestCode == RESULT_OK  && data != null){
            ImageUri = data.getData();
            InputProductImage.setImageURI(ImageUri);

        }
    }
}
