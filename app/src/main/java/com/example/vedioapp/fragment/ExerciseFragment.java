package com.example.vedioapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vedioapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    public static ExerciseFragment newInstance(String param1) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        //点击导航栏按钮，可实现顶部标题同时切换
        onTitleListener = (ExerciseFragment.OnTitleListener) getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        onTitleListener.setTitle(mParam1);

        return view;
    }

    //定义接口，实现点击顶部导航栏，顶部标题切换
    ExerciseFragment.OnTitleListener onTitleListener;
    public interface OnTitleListener{
        void setTitle(String title);
    }
}