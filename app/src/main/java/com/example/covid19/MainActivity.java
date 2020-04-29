package com.example.covid19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_symptoms:
                            selectedFragment = new SymptomsFragment();
                            break;
                        case R.id.nav_preventiveMeasures:
                            selectedFragment = new PreventionFragment();
                            break;
                        case R.id.nav_stats:
                            selectedFragment = new NumbersFragment();
                            break;
                        case R.id.nav_pandemics:
                            selectedFragment = new PandemicsFragment();
                            break;

                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    /*public void setHomeText(){
        TextView text = (TextView) findViewById(R.id.homeTextView);
        String str="";
        try {
            InputStream inputStream = getAssets().open("HomeText.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str= new String(buffer);
        } catch (IOException e){
            e.printStackTrace();
        }
        text.setText(str);
    }*/
}
