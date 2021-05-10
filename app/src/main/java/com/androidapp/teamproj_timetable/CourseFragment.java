package com.androidapp.teamproj_timetable;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CourseFragment extends Fragment {

    MainActivity activity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseFragment newInstance(String param1, String param2) {
        CourseFragment fragment = new CourseFragment();
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

    private ArrayAdapter yearAdapter;
    private Spinner yearSpinner;
    private ArrayAdapter termAdapter;
    private Spinner termSpinner;
    private ArrayAdapter areaAdapter;
    private Spinner areaSpinner;
    private ArrayAdapter majorAdapter;
    private Spinner majorSpinner;

    private String courseUniversity = "";

    private ListView courseListView;
    private CourseListAdapter adapter;
    private List<Course> courseList;

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);

        yearSpinner = (Spinner) getView().findViewById(R.id.yearSpinner);
        termSpinner = (Spinner) getView().findViewById(R.id.termSpinner);
        areaSpinner = (Spinner) getView().findViewById(R.id.areaSpinner);
        majorSpinner = (Spinner) getView().findViewById(R.id.majorSpinner);

        yearAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.year, android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearAdapter);

        termAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.term, android.R.layout.simple_spinner_dropdown_item);
        termSpinner.setAdapter(termAdapter);

        areaAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universityArea, android.R.layout.simple_spinner_dropdown_item);
        areaSpinner.setAdapter(areaAdapter);

        majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.major, android.R.layout.simple_spinner_dropdown_item);
        termSpinner.setAdapter(majorAdapter);

        if(areaSpinner.getSelectedItem().equals("전선"))
        {
            majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universitymajorchoice, android.R.layout.simple_spinner_dropdown_item);
            majorSpinner.setAdapter(majorAdapter);
        }
        if(areaSpinner.getSelectedItem().equals("전심"))
        {
            majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universitymajordeepen, android.R.layout.simple_spinner_dropdown_item);
            majorSpinner.setAdapter(majorAdapter);
        }
        if(areaSpinner.getSelectedItem().equals("균교"))
        {
            majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universitybalancedculture, android.R.layout.simple_spinner_dropdown_item);
            majorSpinner.setAdapter(majorAdapter);
        }
        if(areaSpinner.getSelectedItem().equals("교필"))
        {
            majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universitynecessaryculture, android.R.layout.simple_spinner_dropdown_item);
            majorSpinner.setAdapter(majorAdapter);
        }
        if(areaSpinner.getSelectedItem().equals("일선"))
        {
            majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.universityculturechoice, android.R.layout.simple_spinner_dropdown_item);
            majorSpinner.setAdapter(majorAdapter);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_course, container, false);
    }

}