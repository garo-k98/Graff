package mobi.graff.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeGameFragment extends Fragment {
    TextView t;




    public HomeGameFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_home_game, container, false);
        t = v.findViewById(R.id.text1);
        Bundle b = getArguments();
        if(b!=null) {
            String s = b.getString("s");
            t.setText(s);
        }

        return v;
    }
}