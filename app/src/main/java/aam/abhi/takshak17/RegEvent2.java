package aam.abhi.takshak17;

import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import cz.msebera.android.httpclient.Header;

import android.os.Bundle;
import android.app.Activity;

public class RegEvent2 extends AppCompatActivity implements View.OnClickListener {

    Drawer result = null;
    private ListView listview;
    private IntentIntegrator qrScan;
    //ViewReg Objects
    private int code[] = new int[20];
    private Button buttSub;
    private EditText Name, Email, Number;
    private String unid;
    private boolean flag = true;
    private AsyncHttpClient client = new AsyncHttpClient();
    private int ptr=0,code1,sem;
    ArrayList<String> lis;
    ArrayList<String> all = new ArrayList<>();

    private void setUnid(String unid){
        this.unid = unid;
    }

    private String getUnid(){
        return this.unid;
    }
    public void setflag(boolean fla){
        this.flag = fla;
    }
    public boolean getflag(){
        return flag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_event2);
        final String userID = savedInstanceState.getString("userID");

        all.add("CAD/BIM WORKSHOP");
        all.add("HARLEY DAVIDSON WORKSHOP");all.add("");all.add("");all.add("");all.add("");all.add("");all.add("VYOMA");all.add("ERUDITE");all.add("ISRO EXIBITION");all.add("");all.add("");all.add("ANGRY ROCKET");all.add("FOOSBALL");all.add("SAE GARAGE");
        all.add("SPACE WALK");//16
        all.add("");all.add("");all.add("");all.add("PRO MECHANIS");all.add("CLASH OF QUEENS");all.add("BMW TECHNICAL TALK");all.add("WEARABLE TECHNOLOGY WORKSHOP");
        //mechanical

        all.add("POSTAG:PAPER PRESENTATION");all.add(" ELEKTRA- QUIZ COMPETITION");all.add("BATTLEFIELD:LASER TAG");all.add("REWIRED");all.add("DARK ROOM");all.add("ARCADE-IOUS");
        all.add("INQUESTO: CRIME INVESTIGATIO N");all.add("SUMO SUIT BRAWL");all.add("ZAP 4x4");all.add("THE MYSTERY BOX");
        //ELECTRICAL

        all.add("TECH VILLE");all.add("ENIGMA");all.add("HACKATHON");all.add("CODEAGE17");all.add("Projecto");all.add("LAN Gaming");
        //CSE

        all.add("Contraption");all.add("Slip and Slide");all.add("Slip Soccer");all.add("Labrynthos");
        all.add("Revit");all.add("Crossover");all.add("Nirhara");all.add("Expozione");all.add("Prayaan");all.add("Voila");all.add("MACE DRONE PRIX");all.add("MACE Open School Championship");all.add("Maker Summit Mark 2.0");all.add("Idea Pitching");all.add("Circuit Hunt");all.add("GRAFFITI");all.add("Jugaad IT");all.add("LAN Gaming");
        all.add("VR Gaming");all.add("Pre Workshop");all.add("RoboGenesis");all.add("");all.add("Electronic Wizard");all.add("Techical Quiz");all.add("Word Hunt");all.add("Coding");all.add("Web Designing");all.add("Tresure Hunt");all.add("Live Photography");all.add("Live Quiz");all.add("Live Gaming");all.add("Spot games");
        all.add("Troll Competition");all.add("Elektra");all.add("");all.add("");all.add("");all.add("");all.add("");
        lis= new ArrayList<>();


//        MaterialSpinner spinner1 = (MaterialSpinner) findViewById(R.id.spinsem);
//        spinner1.setItems("--Select Semester--","S1","S2", "S3", "S4", "S5", "S6", "S7","S8");
//        spinner1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
//                sem = position;
//            }
//        });


        buttSub = (Button) findViewById(R.id.sub);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent i = new Intent(RegEvent2.this,RegPage.class);
                startActivityForResult(i,3);
            }
        });
        buttSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i<ptr; ptr++){
                    RequestParams params = new RequestParams();
                    params.put("userID", userID);
                    params.put("eventID", code[i]);
                    client.post("http://takshak.in/2017/public/registration/RegisterEvent", params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            JSONObject json = null;
                            try {
                                json = response.getJSONObject("data");
                                boolean status = json.getBoolean("status");
                                if(status){
                                    Toast.makeText(RegEvent2.this, "Done",Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(RegEvent2.this, "Failed",Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                Toast.makeText(RegEvent2.this, e.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {

                        }
                    });
                }
            }
        });
        // textViewName = (TextView) findViewById(R.id.textViewName);
        //textViewAddress = (TextView) findViewById(R.id.textViewAddress);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withSelectable(false);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName("New Registration").withSelectable(false);
        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Takshak 17").withEmail("takshak@mace.ac.in").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
//create the drawer and remember the `Drawer` result object
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName("Scan").withSelectable(false),
                        new SecondaryDrawerItem().withName("ViewReg All").withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        OnClick(position);
                        return true;   // do something with the clicked item :D
                    }
                })
                .build();
        result.setSelection(3);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.commit();

        //intializing scan object
        qrScan = new IntentIntegrator(this);

    }
    //Getting the scan results

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int fl=1;
        if(requestCode==3){
            try {
                code1=data.getIntExtra("code",10000);
                if(code1!=10000){
                    for(int i=0;i<ptr;i++){
                        if(code1==code[i]){
                            fl=0;
                            Toast.makeText(RegEvent2.this,"Already Added",Toast.LENGTH_LONG).show();
                            break;
                        }else fl=1;
                    }

                    if(fl==1){
                        code[ptr]=code1;
                        ptr++;
                        listview=(ListView)findViewById(R.id.listall);
                        lis.add(all.get(code1-1));
                        ArrayAdapter<String> itemAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lis);
                        listview.setAdapter(itemAdapter);
                        //buttonScan.setText(ptr);
                    }}
            }
            catch (NullPointerException e){
                e.printStackTrace();
            }

        }

    }
    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();

    }

    void OnClick(int position){

        if(position==1){
            result.closeDrawer();
            finish();
        }
        else if(position==3){
            result.closeDrawer();

        }
        else if(position==4){
            result.closeDrawer();
            Intent i = new Intent(this,ScanActivity.class);
            startActivity(i);
            finish();
        }
        else if(position==5){
            result.closeDrawer();
            Intent i = new Intent(this,ViewReg.class);
            startActivity(i);
        }



    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        Intent i = new Intent(this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
    }

}