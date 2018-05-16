package fauzi.hilmy.app18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewHewan, recyclerViewTumbuhan;
    private ArrayList<Poison> arrayListHewan, arrayListTumbuhan;
    AdapterDetail adapterHewan, adapterTumbuhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewHewan = findViewById(R.id.recyclerHewan);
        recyclerViewTumbuhan = findViewById(R.id.recyclerTumbuhan);

        recyclerViewHewan.setHasFixedSize(true);
        recyclerViewTumbuhan.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);

        recyclerViewHewan.setLayoutManager(layoutManager);
        recyclerViewTumbuhan.setLayoutManager(layoutManager1);

        arrayListHewan = new ArrayList<>();
        arrayListTumbuhan = new ArrayList<>();

        arrayListHewan.addAll(PoisonData.getDataHewan());
        arrayListTumbuhan.addAll(PoisonData.getDataTumbuhan());

        adapterHewan = new AdapterDetail(this);
        adapterHewan.setListPoison(arrayListHewan);

        adapterTumbuhan = new AdapterDetail(this);
        adapterTumbuhan.setListPoison(arrayListTumbuhan);

        recyclerViewHewan.setAdapter(adapterHewan);
        recyclerViewTumbuhan.setAdapter(adapterTumbuhan);
    }
}

