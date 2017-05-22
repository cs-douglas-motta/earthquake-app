package br.com.concretesolutions.earthquakeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar mainToolbar;
    private RecyclerView earthquakeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        earthquakeRecyclerView = (RecyclerView) findViewById(R.id.earthquake_recycler_view);

        String[] earthquakeList = {
                "San Francisco",
                "London",
                "Tokyo",
                "Mexico City",
                "Moscow",
                "Rio de Janeiro",
                "Paris"
        };

        EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(Arrays.asList(earthquakeList));

        earthquakeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        earthquakeRecyclerView.setAdapter(earthquakeAdapter);
    }

    private void setUpToolbar() {
        mainToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);
    }

    class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder> {
        private List<String> earthquakeList;

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
            holder.tvNameCountry.setText(earthquakeList.get(position).toString());
        }

        @Override
        public int getItemCount() {
            if (earthquakeList != null) {
                return earthquakeList.size();
            }

            return 0;
        }

        class EarthquakeViewHolder extends RecyclerView.ViewHolder {
            TextView tvNameCountry;

            public EarthquakeViewHolder(View itemView) {
                super(itemView);

                this.tvNameCountry = (TextView) itemView.findViewById(R.id.tvNameCountry);
            }
        }
    }
}
