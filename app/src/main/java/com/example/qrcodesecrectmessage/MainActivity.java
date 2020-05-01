package com.example.qrcodesecrectmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity extends AppCompatActivity {

    String TAG = "Generate QR-Code";
    EditText editText;
    ImageView imageView;
    Button Start;
    String inputvalue;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    protected void onStart() {
        super.onStart();


        //all the connections
        imageView =(ImageView)findViewById(R.id.qrcodeDisplay);

        inputvalue = getIntent().getExtras().getString("Secrect");

        if (inputvalue.length()>0){
            WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();
            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerdimenstion = width < height?width:height ;
            smallerdimenstion = smallerdimenstion*3/4;
            qrgEncoder = new QRGEncoder(inputvalue,null, QRGContents.Type.TEXT,smallerdimenstion);

            try {
                bitmap = qrgEncoder.encodeAsBitmap();
                imageView.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }



        }else{
            editText.setError("Text Required");
        }





    }
}
