package com.example.poolcleaner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.poolcleaner.adapter.ViewPagerAdapter;
import com.example.poolcleaner.fragmentos.CalculoFragment;
import com.example.poolcleaner.fragmentos.TutorialFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TelaPrincipal extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        tabs = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);

        configTablayout();

    }

    private void configTablayout(){
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        adapter.addFragment(new CalculoFragment(), "Cálculo");
        adapter.addFragment(new TutorialFragment(), "Ajuda");

        viewPager.setOffscreenPageLimit(adapter.getItemCount());

        TabLayoutMediator mediator = new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            tab.setText(adapter.getTitle(position));
        });

        mediator.attach();
    }
}