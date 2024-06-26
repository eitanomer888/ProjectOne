package com.example.projectone;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentFirst#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFirst extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private MyDatabaseHelper myDatabaseHelper;

    public FragmentFirst() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFirst.
     */
    // TODO: Rename and change types and number of parameters

    EditText etName;
    Button btn1;
    public static FragmentFirst newInstance(String param1, String param2) {
        FragmentFirst fragment = new FragmentFirst();
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
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        etName = view.findViewById(R.id.etName);
        btn1 = view.findViewById(R.id.btn1);
        myDatabaseHelper = new MyDatabaseHelper(getActivity());
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = etName.getText().toString();
                if(!str.equals(""))
                {
                    etName.setText("");

                    FragmentSecond fs = new FragmentSecond();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fr2,fs).commit();

                   myDatabaseHelper.addBook(str);

                }
            }
        });





        return view;
    }































}