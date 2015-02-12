package com.example.micaela.playstationstore;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DarkSoulsGameFragment extends Fragment {

    TextView mTextViewMessage;
    Button mButtonBuy;

    public DarkSoulsGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dark_souls_game, container, false);
        wireUpViews(rootView);
        prepareButton(rootView);
        return rootView;
    }

    public void getSharedPreferences() {
        Boolean flag = GamesFragment.getSharedPreferences(getActivity());
        if (flag) {
            mTextViewMessage.setText("");
            mButtonBuy.setEnabled(true);
        }
        else {
            mTextViewMessage.setText(R.string.text_view_message);
            mButtonBuy.setEnabled(false);
        }
    }

    public void prepareButton(View rootView) {
        mButtonBuy = (Button)rootView.findViewById(R.id.button);
    }

    public void wireUpViews(View rootView) {
        mTextViewMessage = (TextView)rootView.findViewById(R.id.text_view_message);
    }

    @Override
    public void onResume() {
        super.onResume();
        getSharedPreferences();
    }

}

