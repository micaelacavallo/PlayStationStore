package com.example.micaela.playstationstore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class GranTheftAutoGameFragment extends Fragment {
    TextView mTextViewMessage;
    Button mButtonBuy;

    public GranTheftAutoGameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_gran_theft_auto_game, container, false);
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


