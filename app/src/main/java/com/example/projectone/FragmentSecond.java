package com.example.projectone;

import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.PrecomputedText;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSecond#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSecond extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MyDatabaseHelper myDatabaseHelper;


    TableLayout tbLay;
    TableRow tr0;

    public FragmentSecond() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSecond.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSecond newInstance(String param1, String param2) {
        FragmentSecond fragment = new FragmentSecond();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        myDatabaseHelper = new MyDatabaseHelper(getActivity());


        tbLay = view.findViewById(R.id.tbLay);
        tr0 = view.findViewById(R.id.tr0);

        Cursor cursor = myDatabaseHelper.readAllData();


        if(cursor != null)
        {
            int n = cursor.getCount();
            cursor.moveToFirst();
            for (int i = 0; i < n; i++)
            {
                String str = cursor.getString(1);
                Addy(str);
                cursor.moveToNext();
            }
        }







        return view;
    }





    public void Addy(String s)
    {
            TableRow row = new TableRow(requireActivity());
            row.setLayoutParams(new TableRow.LayoutParams(-1, -2));
            row.setGravity(17);

            TextView txt = new TextView(requireActivity());


            CheckBox cb = new CheckBox(requireActivity());
            TableRow.LayoutParams Params1 = new TableRow.LayoutParams();
            TableRow.LayoutParams Params2 = new TableRow.LayoutParams();
            Params1.weight = 5;
            Params2.weight = 2;
            Params2.gravity = Gravity.CENTER;



            txt.setText(s);
            txt.setTextColor(getResources().getColor(R.color.black));
            txt.setTextSize(20);
            txt.setGravity(Gravity.CENTER);



            cb.setLayoutParams(Params2);
            txt.setLayoutParams(Params1);
            cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                    {
                        txt.setTextColor(Color.BLUE);
                    }
                    else
                    {
                        txt.setTextColor(Color.BLACK);
                    }
                }
            });
            row.addView(cb);
            row.addView(txt);
            tbLay.addView(row);
    }




























}