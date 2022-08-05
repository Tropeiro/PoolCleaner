package com.example.poolcleaner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.poolcleaner.adapter.ViewPagerAdapter;
import com.example.poolcleaner.fragmentos.CalculoFragment;
import com.example.poolcleaner.fragmentos.FragmentDica;
import com.example.poolcleaner.fragmentos.TutorialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TelaPrincipal extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        navigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.fragmentajuda:
                        replaceFragment(new TutorialFragment());
                        break;

                    case R.id.fragmentcalculo:
                        replaceFragment(new CalculoFragment());
                        break;
                }

                return true;
            }
        });

    }

    public void replaceFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fmt = fm.beginTransaction();
        fmt.replace(R.id.fragmentContainerView, fragment);
        fmt.commit();

    }

    public void replaceSelectedMenu(int id){

        switch (id) {

            case 1:
                navigationView.setSelectedItemId(R.id.fragmentajuda);
                break;

            case 2:
                navigationView.setSelectedItemId(R.id.fragmentcalculo);
                break;


        }

    }
}