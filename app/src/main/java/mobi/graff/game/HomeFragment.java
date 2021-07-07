package mobi.graff.game;

//import android.graphics.Color;
import android.os.Bundle;

//import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;


public class HomeFragment extends Fragment {

//    ListView lv;
//    ArrayList<String> al;
//    ArrayAdapter<String> adapter;

    public ArrayList<String> data = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ListView lv1 = view.findViewById(R.id.idListView);
        generateListContent();
        lv1.setAdapter(new HomeFragment.MyListAdapter(this, R.layout.list_item, data));
        lv1.setOnItemClickListener((parent, view1, position, id) -> {
            String s = data.get(position);
            Home mnl = (Home) getActivity();
            assert mnl != null;
            mnl.f1(s);
        });

        return view;

    }

    private void generateListContent() {
        for(int i = 0; i < 20; i++) {
            data.add("This is row number " + i);
        }
    }

    private static class MyListAdapter extends ArrayAdapter<String> {
        private final int layout;

        private MyListAdapter(HomeFragment context, int resource, List<String> objects) {
            super(context.getActivity(), resource, objects);
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            HomeFragment.ViewHolder mainViewHolder;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                HomeFragment.ViewHolder viewHolder = new HomeFragment.ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.List_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.List_item_name);
                viewHolder.button = (Button) convertView.findViewById(R.id.List_item_button);
                viewHolder.description = (TextView) convertView.findViewById(R.id.List_item_des);
                convertView.setTag(viewHolder);
            }
            mainViewHolder = (HomeFragment.ViewHolder) convertView.getTag();
            mainViewHolder.button.setOnClickListener(v -> Toast.makeText(getContext(), "Button was clicked for List item " + position, Toast.LENGTH_LONG).show());
            mainViewHolder.title.setText(getItem(position));

            return convertView;
        }
    }

    private static class ViewHolder {
        ImageView thumbnail;
        TextView title;
        Button button;
        TextView description;
    }
}
