package mobi.graff.game;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
//import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        HomeFragment m1 = new HomeFragment();
        t.add(R.id.container, m1);
        t.commit();


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod = menuItem -> {

        Fragment fragment= null;
        switch (menuItem.getItemId()) {
            case R.id.Home:
                fragment = new HomeFragment();
                break;

            case R.id.Games:
                fragment = new GamesFragment();
                break;

            case R.id.Create:
                fragment = new CreateFragment();
                break;

            case R.id.Profile:
                fragment = new ProfileFragment();
                break;
        }

        assert fragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        return true;
    };

    public void f1(String s) {
        FragmentManager manager1 = getSupportFragmentManager();
        FragmentTransaction t1 = manager1.beginTransaction();
        HomeGameFragment m22 = new HomeGameFragment();
        Bundle b2 = new Bundle();
        b2.putString("s", s);
        m22.setArguments(b2);
        t1.replace(R.id.container, m22);
        t1.commit();
    }
}