package com.example.rcv_gra;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {



    private RecyclerView rcvDetail;
    private RecyclerView rcvLed;
    private DeviceAdapter deviceAdapter;
    private LedAdapter ledAdapter;
    public List<Device> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        rcvDetail = view.findViewById(R.id.rcv_detail);
        rcvDetail.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Retrieve room name from arguments
        Bundle args = getArguments();

        if (args != null) {
            String roomName = args.getString("roomName");
            Log.d("roomName", "roomName:" + roomName);

            TextView txtNameRoom = view.findViewById(R.id.txtNameRoom);
            txtNameRoom.setText(roomName);
        }
        int index = getArguments().getInt("index");
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);

        switch (index){
            case 0:
                //        set data trong list len view
                deviceAdapter = new DeviceAdapter(getListDevice0());
                rcvDetail.setAdapter(deviceAdapter);
                //    tao khoan cach giua cac item
                rcvDetail.addItemDecoration(itemDecoration);

                rcvLed = view.findViewById(R.id.rcv_detail_led);
                rcvLed.setLayoutManager(new LinearLayoutManager(getActivity()));
                rcvLed.addItemDecoration(itemDecoration);

                // Assuming you want 10 items in the RecyclerView.
                ledAdapter = new LedAdapter(3);

                rcvLed.setAdapter(ledAdapter);
                break;

            case 2:
                //        set data trong list len view
                deviceAdapter = new DeviceAdapter(getListDevice1());
                rcvDetail.setAdapter(deviceAdapter);
                //    tao khoan cach giua cac item
                rcvDetail.addItemDecoration(itemDecoration);

                rcvLed = view.findViewById(R.id.rcv_detail_led);
                rcvLed.setLayoutManager(new LinearLayoutManager(getActivity()));
                rcvLed.addItemDecoration(itemDecoration);

                // Assuming you want 10 items in the RecyclerView.
                ledAdapter = new LedAdapter(3);

                rcvLed.setAdapter(ledAdapter);
                break;
            case 1:
                //        set data trong list len view
                deviceAdapter = new DeviceAdapter(getListDevice2());
                rcvDetail.setAdapter(deviceAdapter);
                //    tao khoan cach giua cac item
                rcvDetail.addItemDecoration(itemDecoration);

                rcvLed = view.findViewById(R.id.rcv_detail_led);
                rcvLed.setLayoutManager(new LinearLayoutManager(getActivity()));
                rcvLed.addItemDecoration(itemDecoration);

                // Assuming you want 10 items in the RecyclerView.
                ledAdapter = new LedAdapter(2);

                rcvLed.setAdapter(ledAdapter);
                break;
            default:
                //        set data trong list len view
                deviceAdapter = new DeviceAdapter(getListDevice());
                rcvDetail.setAdapter(deviceAdapter);
                //    tao khoan cach giua cac item
                rcvDetail.addItemDecoration(itemDecoration);

                rcvLed = view.findViewById(R.id.rcv_detail_led);
                rcvLed.setLayoutManager(new LinearLayoutManager(getActivity()));
                rcvLed.addItemDecoration(itemDecoration);

                // Assuming you want 10 items in the RecyclerView.
                ledAdapter = new LedAdapter(2);

                rcvLed.setAdapter(ledAdapter);
                break;


        }



        // tao OnClickListener cho button
        Button btnAddRoom = view.findViewById(R.id.btnBack);
        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new instance of HomeFragment
                HomeFragment homeFragment = new HomeFragment();

                // Navigate to HomeFragment
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, homeFragment)
                        .commit();
            }
        });


        return view;
    }

    private List<Device> getListDevice0() {
        list = new ArrayList<>();
        if(list.size() == 0){
            list.add(new Device(R.mipmap.ic_launcher, "Nhiệt độ ", "30c"));
            list.add(new Device(R.mipmap.ic_launcher, "Độ ẩm", "89"));
        }
        return list;
    }

    private List<Device> getListDevice2() {
        list = new ArrayList<>();
        if(list.size() == 0){
            list.add(new Device(R.mipmap.ic_launcher, "Nhiệt độ ", "25c"));
            list.add(new Device(R.mipmap.ic_launcher, "Độ ẩm", "20"));
            list.add(new Device(R.mipmap.ic_launcher, "Quạt", "70"));
        }
        return list;
    }

    private List<Device> getListDevice1() {
        list = new ArrayList<>();
        if(list.size() == 0){
            list.add(new Device(R.mipmap.ic_launcher, "Nhiệt độ ", "20c"));
            list.add(new Device(R.mipmap.ic_launcher, "Độ ẩm", "79"));

        }
        return list;
    }

    // them cac thiet bi vao ArrayList
    private List<Device> getListDevice() {
//         list = new ArrayList<>();
        if(list.size() == 0){
            list.add(new Device(R.mipmap.ic_launcher, "Nhiệt độ ", "30c"));
            list.add(new Device(R.mipmap.ic_launcher, "Độ ẩm", "89"));
            list.add(new Device(R.mipmap.ic_launcher, "Quạt", "50"));
        }

        return list;
    }
}