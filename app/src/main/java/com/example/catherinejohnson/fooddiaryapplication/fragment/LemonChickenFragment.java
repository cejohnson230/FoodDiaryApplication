package com.example.catherinejohnson.fooddiaryapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catherinejohnson.fooddiaryapplication.R;
import com.example.catherinejohnson.fooddiaryapplication.ingredientDialogs.CustomDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LemonChickenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LemonChickenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public LemonChickenFragment() {
        // Required empty public constructor
    }

    public static LemonChickenFragment newInstance(String param1, String param2) {
        LemonChickenFragment fragment = new LemonChickenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lemon_chicken, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.activity_show_ingredientbt)
    public void show(View v){



            CustomDialog customDialog =
                    new CustomDialog(this.getContext(), new CustomDialog.ICustomDialongListener() {

                        @Override
                        public void onOKClicked(String msg) {

                        }
                    });
            //This ables the user to touch the empty space to go back
            customDialog.setCanceledOnTouchOutside(true);
            customDialog.show();
        }
    }


