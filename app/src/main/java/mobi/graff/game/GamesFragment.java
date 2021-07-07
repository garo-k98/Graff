package mobi.graff.game;

//import android.content.Context;
import android.os.Bundle;

//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GamesFragment extends Fragment {

    //ListView lv1,lv2;
    //ArrayList<String> al1, al2;
    //ArrayAdapter<String> adapter;


    public ArrayList<String> data = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_games, container, false);
        ListView lv1 = view.findViewById(R.id.listView1);
        ListView lv2 = view.findViewById(R.id.listView2);
        generateListContent();
        lv1.setAdapter(new MyListAdapter(this, R.layout.list_item, data));
        lv2.setAdapter(new MyListAdapter(this, R.layout.list_item, data));
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
            }
        });
        //al1 = new ArrayList<>();
        //al2 = new ArrayList<>();
        //adapter = new ArrayAdapter<>(getActivity(), android.R.layout.list_item, data);
        //lv1.setAdapter(adapter);
        //adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_activated_1, data);
        //lv2.setAdapter(adapter);

        return view;

    }

    private void generateListContent() {
        for(int i = 0; i < 10; i++) {
            data.add("This is row number " + i);
        }
    }

    private static class MyListAdapter extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private MyListAdapter(GamesFragment context, int resource, List<String> objects) {
            super(context.getActivity(), resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewHolder;
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.List_item_thumbnail);
                viewHolder.title = (TextView) convertView.findViewById(R.id.List_item_name);
                viewHolder.button = (Button) convertView.findViewById(R.id.List_item_button);
                viewHolder.description = (TextView) convertView.findViewById(R.id.List_item_des);
                convertView.setTag(viewHolder);
            }
            mainViewHolder = (ViewHolder) convertView.getTag();
            mainViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Button was clicked for List item " + position, Toast.LENGTH_LONG).show();
                }
            });
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