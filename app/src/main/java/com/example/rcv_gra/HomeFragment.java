package com.example.rcv_gra;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView rcvData;
    private RoomAdapter roomAdapter;
    public List<Room> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rcvData = view.findViewById(R.id.rcv_data);
        rcvData.setLayoutManager(new LinearLayoutManager(getActivity()));

//        tao khoan cach giua cac item
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

//        set data trong list len view
        roomAdapter = new RoomAdapter(getListRoom());
        rcvData.setAdapter(roomAdapter);

        // tao OnClickListener cho button
        Button btnAddRoom = view.findViewById(R.id.btnAddRoom);
        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tao mot doi tuong phong khac va them vao list
                Room newRoom = new Room(R.mipmap.ic_launcher, "New Room", "0 device");
                list.add(newRoom);

                // thong bao adapter biet dua lieu da bi thay doi
                roomAdapter.notifyDataSetChanged();
            }
        });
        return view;

    }

    // them cac phong vao ArrayList
    public List<Room> getListRoom() {
//        list = new ArrayList<>();
        if(list.size() == 0){
            list.add(new Room(R.drawable.barn, "Room 1", "5 device"));
            list.add(new Room(R.drawable.barn, "Room 2", "5 device"));
            list.add(new Room(R.drawable.barn, "Room 3", "5 device"));
        }

        return list;
    }
}