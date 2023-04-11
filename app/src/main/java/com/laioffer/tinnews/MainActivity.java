package com.laioffer.tinnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.network.NewsApi;
import com.laioffer.tinnews.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BottomNavigationView can response to menuItem click behavior
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // mvc
        // FragmentContainerView -> view
        // NavHostFragment -> Controller
        // nav_graph -> data

        // when click on bottom nav menu, ask controller to set screen on the view

        // get controller
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        // router
        navController = navHostFragment.getNavController();

        // connect navController with BottomNavigationView
        NavigationUI.setupWithNavController(navView, navController);
        // connect with action bar and back button
        NavigationUI.setupActionBarWithNavController(this, navController);

        // tmp code, will remove
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}
