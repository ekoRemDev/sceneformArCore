package net.iotinn.sceneformfurniture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.ux.ArFragment;

public class MainActivity extends AppCompatActivity {

    //
    private ArFragment fragment;

    private String selectedObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_fragment);

        InitializeGallery();

        fragment.setOnTapArPlaneListener((HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
            Log.d("model", selectedObject);

        });

    }

    private void InitializeGallery() {
        LinearLayout gallery = findViewById(R.id.gallery_layout);

        ImageView chair = new ImageView(this);
        chair.setImageResource(R.drawable.chair_thumb);
        chair.setContentDescription("chair");
        chair.setOnClickListener(view -> {
            selectedObject = "chair";
        });
        gallery.addView(chair);


        ImageView couch = new ImageView(this);
        couch.setImageResource(R.drawable.couch_thumb);
        couch.setContentDescription("couch");
        couch.setOnClickListener(view -> {
            selectedObject = "couch";
        });
        gallery.addView(couch);


        ImageView lamp = new ImageView(this);
        lamp.setImageResource(R.drawable.lamp_thumb);
        lamp.setContentDescription("lamp");
        lamp.setOnClickListener(view -> {
            selectedObject = "lamp";
        });
        gallery.addView(lamp);
    }


}
