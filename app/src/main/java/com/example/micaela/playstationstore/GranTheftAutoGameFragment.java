package com.example.micaela.playstationstore;


import android.content.Intent;
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
    TextView mTextViewPrice;

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
        Boolean flag = GamesFragment.isUserInformationComplete(getActivity());
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
        mButtonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prepareIntent();
            }

            public void prepareIntent() {
                String[] user_data = GamesFragment.getUserInformation(getActivity());
                Intent intent = new Intent(getActivity(), ShowDataConfirmationActivity.class);
                intent.putExtra(GamesFragment.USER_INFORMATION, user_data);
                intent.putExtra(GamesFragment.GAME_NAME, GamesFragment.GTA);
                intent.putExtra(GamesFragment.GAME_PRICE, mTextViewPrice.getText().toString());
                startActivity(intent);
            }
        });

    }

    public void wireUpViews(View rootView) {
        mTextViewMessage = (TextView)rootView.findViewById(R.id.text_view_message);
        mTextViewPrice = (TextView)rootView.findViewById(R.id.text_view_gta_price);
    }

    @Override
    public void onResume() {
        super.onResume();
        getSharedPreferences();
    }
}


