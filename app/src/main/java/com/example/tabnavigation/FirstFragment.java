package com.example.tabnavigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    private ArrayList<ItemData> itemValues;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private FloatingActionButton addButton;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        addButton = view.findViewById(R.id.addButton);

        itemValues = new ArrayList<>();
        for (int i = 0;i<=10;i++){
            ItemData item=new ItemData();
            item.itemTitle="Title Data - "+i;
            item.itemSubtitle="Subtitle Data - "+i;
            itemValues.add(item);
        }

        itemAdapter=new ItemAdapter(getActivity(), itemValues);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    private void addData(){
        ItemData item=new ItemData();
        item.itemTitle="Title Data - Baru";
        item.itemSubtitle="Subtitle Data - Baru";
        itemValues.add(item);
        itemAdapter.notifyDataSetChanged();
    }
}