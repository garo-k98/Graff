package mobi.graff.game;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> adapter;




    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lv = (ListView) view.findViewById(R.id.idListView);
        al = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, al);
        lv.setAdapter(adapter);
        al.add("one");
        al.add("two");
        al.add("three");
        al.add("four");
        al.add("five");
        al.add("six");
        al.add("seven");
        al.add("eight");
        al.add("nine");
        al.add("ten");
        al.add("eleven");
        al.add("twelve");
        al.add("thirteen");
        al.add("fourteen");

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = al.get(position);
                Home mnl = (Home) getActivity();
                mnl.f1(s);
            }
        });*/


        return view;

    }
}