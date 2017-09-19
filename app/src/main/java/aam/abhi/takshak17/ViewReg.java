package aam.abhi.takshak17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class ViewReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        MaterialSpinner spinner1 = (MaterialSpinner) findViewById(R.id.spinner3);
        spinner1.setItems("--Select Department--","CSE", "Mechanical", "Civil", "EEE", "EC", "MCA");
        spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

            }
        });
        }
}
