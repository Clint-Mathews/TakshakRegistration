package aam.abhi.takshak17;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

public class RegPage extends AppCompatActivity {
public int dpcode=1000,evcode=1000,code,ptr;
    public int[] code1;
    public String name,college,branch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);
        MaterialSpinner spinner1 = (MaterialSpinner) findViewById(R.id.spinner1);



        spinner1.setItems("--Select Department--","CSE", "Mechanical", "Civil", "EEE", "EC", "MCA");

        spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //Snackbar.make(view, "Clicked " + item+position, Snackbar.LENGTH_LONG).show();
                MaterialSpinner spinner2 = (MaterialSpinner) findViewById(R.id.spinner2);
                dpcode=position;
                if(position==1)
                spinner2.setItems("--Select Event--","TECH VILLE", "ENIGMA", "HACKATHON", "CODEAGE17", "Projecto","LAN Gaming");
                else if(position==2)
                    spinner2.setItems("--Select Event--","CAD/BIM WORKSHOP", "HARLEY DAVIDSON WORKSHOP", "VYOMA", "ISRO EXIBITION", "ERUDITE","FOOSBALL","ANGRY ROCKET","SAE GARAGE","SPACE WALK","PRO MECHANISM","CLASH OF QUEENS");
                else if(position==3)
                    spinner2.setItems("--Select Event--","Contraption", "Slip and Slide", "Slip Soccer", "Labrynthos", "Revit","Crossover","Nirhara","Expozione","Prayaan","Voila");
                else if(position==4)
                    spinner2.setItems("--Select Event--","POSTAG:PAPER PRESENTATION", "ELEKTRA- QUIZ COMPETITION", "BATTLEFIELD:LASER TAG", "REWIRED", "DARK ROOM","ARCADE-IOUS","INQUESTO: CRIME INVESTIGATION","SUMO SUIT BRAWL","ZAP 4x4","THE MYSTERY BOX","Elektra","BMW TECHNICAL TALK");
                else if(position==5)
                    spinner2.setItems("--Select Event--","MACE DRONE PRIX", "MACE Open School Championship", "Maker Summit Mark 2.0", "Idea Pitching", "Circuit Hunt","GRAFFITI","Jugaad IT","LAN Gaming","VR Gaming","Pre Workshop","Pre Workshop");
                else if(position==6)
                    spinner2.setItems("--Select Event--","Techical Quiz","Word Hunt","Coding","Web Designing","Tresure Hunt","Live Photography","Live Quiz","Live Gaming","Spot games","Troll Competition");
                else if(position==0)
                    spinner2.setItems("");
                spinner2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

                    @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                       // Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
                        evcode=position;
                        switch (dpcode){
                            case 1:
                                switch (evcode){
                                    case 1:
                                        code=34;
                                        break;
                                    case 2:
                                        code=35;
                                        break;
                                    case 3:
                                        code=36;
                                        break;
                                    case 4:
                                        code=37;
                                        break;
                                    case 5:
                                        code=38;
                                        break;
                                    case 6:
                                        code=39;
                                        break;

                                }
                                break;
                            case 2:
                                switch (evcode){
                                    case 1:
                                        code=1;
                                        break;
                                    case 2:
                                        code=2;
                                        break;
                                    case 3:
                                        code=8;
                                        break;
                                    case 4:
                                        code=10;
                                        break;
                                    case 5:
                                        code=9;
                                        break;
                                    case 6:
                                        code=14;
                                        break;
                                    case 7:
                                        code=13;
                                        break;
                                    case 8:
                                        code=15;
                                        break;
                                    case 9:
                                        code=16;
                                        break;
                                    case 10:
                                        code=20;
                                        break;
                                    case 11:
                                        code=21;
                                        break;

                                }



                                break;
                            case 3:

                                switch (evcode){
                                    case 1:
                                        code=40;
                                        break;
                                    case 2:
                                        code=41;
                                        break;
                                    case 3:
                                        code=42;
                                        break;
                                    case 4:
                                        code=43;
                                        break;
                                    case 5:
                                        code=44;
                                        break;
                                    case 6:
                                        code=45;
                                        break;
                                    case 7:
                                        code=46;
                                        break;
                                    case 8:
                                        code=47;
                                        break;
                                    case 9:
                                        code=48;
                                        break;
                                    case 10:
                                        code=49;
                                        break;


                                }
                                break;
                            case 4:
                                switch (evcode){
                                    case 1:
                                        code=24;
                                        break;
                                    case 2:
                                        code=25;
                                        break;
                                    case 3:
                                        code=26;
                                        break;
                                    case 4:
                                        code=27;
                                        break;
                                    case 5:
                                        code=28;
                                        break;
                                    case 6:
                                        code=29;
                                        break;
                                    case 7:
                                        code=30;
                                        break;
                                    case 8:
                                        code=31;
                                        break;
                                    case 9:
                                        code=32;
                                        break;
                                    case 10:
                                        code=33;
                                        break;
                                    case 11:
                                        code=73;
                                        break;
                                    case 12:
                                        code=22;
                                        break;

                                }
                                break;
                            case 5:
                                switch (evcode){
                                    case 1:
                                        code=50;
                                        break;
                                    case 2:
                                        code=51;
                                        break;
                                    case 3:
                                        code=52;
                                        break;
                                    case 4:
                                        code=53;
                                        break;
                                    case 5:
                                        code=54;
                                        break;
                                    case 6:
                                        code=55;
                                        break;
                                    case 7:
                                        code=56;
                                        break;
                                    case 8:
                                        code=57;
                                        break;
                                    case 9:
                                        code=58;
                                        break;
                                    case 10:
                                        code=59;
                                        break;
                                    case 11:
                                        code=60;
                                        break;
                                }
                                break;
                            case 6:
                                switch (evcode){
                                    case 1:
                                        code=63;
                                        break;
                                    case 2:
                                        code=64;
                                        break;
                                    case 3:
                                        code=65;
                                        break;
                                    case 4:
                                        code=66;
                                        break;
                                    case 5:
                                        code=67;
                                        break;
                                    case 6:
                                        code=68;
                                        break;
                                    case 7:
                                        code=69;
                                        break;
                                    case 8:
                                        code=70;
                                        break;
                                    case 9:
                                        code=71;
                                        break;
                                    case 10:
                                        code=72;
                                        break;

                                }
                                break;

                        }
                    }
                });

            }
        });




    }


    public void OK(View v){
if(dpcode!=1000&&evcode!=1000) {
    Intent i = new Intent();
    i.putExtra("code", code);
    setResult(3, i);
    finish();
}

//
//        Log.d("hello", "OK: on");
//        tk.add(code);
//        Log.d("hello", "OK: on");
//        tk.inc();
//        Log.d("hello", "OK: on");
        //Toast.makeText(RegPage.this,tk.ptr,Toast.LENGTH_LONG).show();
        //finish();
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();

        Intent i =new Intent();
        i.putExtra("code",10000);
        setResult(3,i);
        finish();
    }


}
