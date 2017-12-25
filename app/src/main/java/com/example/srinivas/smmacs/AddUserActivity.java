package com.example.srinivas.smmacs;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Created by chakravarthy on 22/12/17.
 */

public class AddUserActivity extends Activity implements View.OnClickListener {
    ImageView ivSelectImg;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    RelativeLayout relativeImage;

    private static final int PERMISSION_REQUEST_CODE = 1;

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
                return true;
            }
            else if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED)
            {
                return true;
            }
            else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v(TAG,"Permission: "+permissions[0]+ "was "+grantResults[0]);
            //resume tasks needing this permission
        }
    }

//    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//
//        if (checkSelfPermission(Manifest.permission.SEND_SMS)
//                == PackageManager.PERMISSION_DENIED) {
//
//            Log.d("permission", "permission denied to SEND_SMS - requesting it");
//            String[] permissions = {Manifest.permission.SEND_SMS};
//
//            requestPermissions(permissions, PERMISSION_REQUEST_CODE);
//
//        }
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduser_layout);
        relativeImage = (RelativeLayout)findViewById(R.id.relativeImage);
        //ivSelectImg = (ImageView)findViewById(R.id.imageLabel);

        relativeImage.setOnClickListener(this);
        isStoragePermissionGranted();
    }

    @Override
    public void onClick(View v) {
        if (v == relativeImage) {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(galleryIntent, RESULT_LOAD_IMG);


        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                 ivSelectImg = (ImageView) findViewById(R.id.imageLabel);

               // LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(100,100);
               // ivSelectImg.setLayoutParams(parms);
                // Set the Image in ImageView after decoding the String
                ivSelectImg.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));


            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }
}