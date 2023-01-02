package com.newsapp.abhygunawan;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.newsapp.abhygunawan.Fragments.DevProfile;
import com.newsapp.abhygunawan.Fragments.Home;
import com.newsapp.abhygunawan.Fragments.Publish;
import com.newsapp.abhygunawan.Fragments.UProfile;
import com.newsapp.abhygunawan.R;
import com.newsapp.abhygunawan.databinding.ActivityDrawerBinding;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActivityDrawerBinding binding;
    GoogleSignInAccount account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupdrawer();

    }

    private void setupdrawer() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new Home());
        fragmentTransaction.commit();

        binding.menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawer.openDrawer(Gravity.LEFT);
            }
        });

        binding.navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new Home());
                fragmentTransaction.commit();
                break;
            case R.id.nav_publish:
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.frame_layout, new Publish());
                fragmentTransaction1.commit();
                break;
            case R.id.dev_profile:
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.frame_layout, new DevProfile());
                fragmentTransaction2.commit();
                break;
            case R.id.Uprofile:
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.frame_layout, new UProfile());
                fragmentTransaction3.commit();
                break;

        }
        binding.drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}