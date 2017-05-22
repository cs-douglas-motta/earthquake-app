package br.com.concretesolutions.earthquakeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.concretesolutions.earthquakeapp.data.Earthquake;

public class MainActivity extends AppCompatActivity {
    private Toolbar mainToolbar;
    private RecyclerView earthquakeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        List<Earthquake> earthquakeList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Earthquake earthquake = new Earthquake(4.7, "San Francisco", new Date());
            earthquakeList.add(earthquake);
        }

        setUpRecyclerView(earthquakeList);
    }

    private void setUpToolbar() {
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
    }

    private void setUpRecyclerView(List<Earthquake> earthquakeList) {
        earthquakeRecyclerView = (RecyclerView) findViewById(R.id.earthquake_recycler_view);
        earthquakeRecyclerView.setHasFixedSize(true);

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(earthquakeList);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(earthquakeRecyclerView.getContext(), DividerItemDecoration.VERTICAL);

        earthquakeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        earthquakeRecyclerView.addItemDecoration(dividerItemDecoration);
        earthquakeRecyclerView.setAdapter(earthquakeAdapter);

    }

    class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {
        private List<Earthquake> earthquakeList;

        public EarthquakeAdapter(List earthquakeList) {
            this.earthquakeList = earthquakeList;
        }

        @Override
        public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.earthquake_item, parent, false);
            return new EarthquakeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(EarthquakeViewHolder holder, int position) {
            holder.tvMagnitude.setText(Double.toString(earthquakeList.get(position).getMagnitude()));
            holder.tvLocation.setText(earthquakeList.get(position).getLocation());
            holder.tvDate.setText(new SimpleDateFormat("MMMM dd, yyyy").format(earthquakeList.get(position).getDate()).toString());
        }

        @Override
        public int getItemCount() {
            if (earthquakeList != null) {
                return earthquakeList.size();
            }

            return 0;
        }

        class EarthquakeViewHolder extends RecyclerView.ViewHolder {
            TextView tvMagnitude;
            TextView tvLocation;
            TextView tvDate;

            public EarthquakeViewHolder(View itemView) {
                super(itemView);

                this.tvMagnitude = (TextView) itemView.findViewById(R.id.tvMagnitude);
                this.tvLocation = (TextView) itemView.findViewById(R.id.tvLocation);
                this.tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            }
        }
    }
}
