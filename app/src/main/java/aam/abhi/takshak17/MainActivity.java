package aam.abhi.takshak17;

//import android.app.Fragment;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class MainActivity extends AppCompatActivity {
Drawer result = null;
    Fragment fragment = null;
    int unlocked=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    void OnClick(int position){

        if(position==1){
            result.closeDrawer();
        }
        else if(position==3){
            result.closeDrawer();
            Intent i = new Intent(this,RegAct.class);
            startActivity(i);
        }
        else if(position==4){
            result.closeDrawer();
            Intent i = new Intent(this,ScanActivity.class);
            startActivity(i);
        }
        else if(position==5){
            result.closeDrawer();
            Intent i = new Intent(this,ViewReg.class);
            startActivity(i);
        }





    }

    public void onLogin(View v){
        EditText e= (EditText)findViewById(R.id.pin);
        if(e.getText().toString().equals("55555")){

                unlocked=1;
                setContentView(R.layout.altlayout);
                //if you want to update the items at a later time it is recommended to keep it in a variable
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
                result.setSelection(1);


            Button b1=(Button)findViewById(R.id.b1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this,RegAct.class);
                    startActivity(i);                }
            });

            Button b2=(Button)findViewById(R.id.b2);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this,ScanActivity.class);
                    startActivity(i);
                }
            });
            Button b3 = (Button)findViewById(R.id.b3);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this,ViewReg.class);
                    startActivity(i);
                }
            });
        }
    }
}
