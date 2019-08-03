package cc.goodman.rave;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavController navController = Navigation.findNavController(this, R.id.navHostMain);
        BottomNavigationView bnvMain = findViewById(R.id.bnvMain);
        NavigationUI.setupWithNavController(bnvMain, navController);

        navController.addOnDestinationChangedListener((ctrl, dst, arg) -> {
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostMain);
            int count = Objects.requireNonNull(navHostFragment).getChildFragmentManager().getBackStackEntryCount();
            Log.i("backstack", "back stack count: " + count);
        });
    }
}
