package aam.abhi.takshak17;

import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
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

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RegAct extends AppCompatActivity implements View.OnClickListener {
    Drawer result = null;
    HttpResponse response = null;
    private IntentIntegrator qrScan;
    //View Objects
    private Button buttonScan, buttSub;
    private String unid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        //View objects
        buttonScan = (Button) findViewById(R.id.sc);
        buttSub = (Button) findViewById(R.id.sub);
        buttSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new Retrieve().execute(new URI("https://www.google.com"));

                }catch (URISyntaxException e){
                    e.printStackTrace();
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
                        new SecondaryDrawerItem().withName("Scan").withSelectable(false)
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

        //attaching onclick listener
        buttonScan.setOnClickListener(this);

    }
    //Getting the scan results

    class Retrieve extends AsyncTask<URI,Void,HttpResponse>{
        private Exception exception;
        protected HttpResponse doInBackground(URI... uris){
            EditText name = (EditText)findViewById(R.id.name);
            EditText college = (EditText)findViewById(R.id.college);
            EditText branch = (EditText)findViewById(R.id.branch);


            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(uris[0]);
                response = client.execute(request);
            }catch (ClientProtocolException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
            return response;
        }
        protected void onPostExecute(HttpResponse httpResponse){
            buttSub.setText("yippe");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    unid=(obj.getString("unid"));
                    //textViewAddress=(obj.getString("address"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();

    }

    void OnClick(int position){

        if(position==1){
            Toast.makeText(RegAct.this, "Home", Toast.LENGTH_SHORT).show();
            result.closeDrawer();
            finish();
        }
        else if(position==3){
            Toast.makeText(RegAct.this, "New Reg", Toast.LENGTH_SHORT).show();
            result.closeDrawer();

        }
        else if(position==4){
            Toast.makeText(RegAct.this, "Scan", Toast.LENGTH_SHORT).show();
            result.closeDrawer();
            Intent i = new Intent(this,ScanActivity.class);
            startActivity(i);
            finish();
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
