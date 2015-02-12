package com.example.micaela.playstationstore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShowDataConfirmationFragment extends Fragment {
    TextView mTextViewSummaryUser;
    TextView mTextViewSummaryGame;

    public ShowDataConfirmationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_data_confirmation, container, false);

        String[] data_user = getActivity().getIntent().getStringArrayExtra(GamesFragment.USER_INFORMATION);
        String game_name = getActivity().getIntent().getStringExtra(GamesFragment.GAME_NAME);
        String game_price = getActivity().getIntent().getStringExtra(GamesFragment.GAME_PRICE);
        prepareTextViews(rootView, data_user, game_name, game_price);
        return rootView;
    }

    public void prepareTextViews(View rootView, String[] data_user, String game_name, String game_price) {
        mTextViewSummaryUser = (TextView)rootView.findViewById(R.id.text_view_summary_user);
        mTextViewSummaryGame = (TextView)rootView.findViewById(R.id.text_view_summary_game);
        mTextViewSummaryUser.setText("Full name: " + data_user[0] + "\n" +
                "Mail: " + data_user[1] + "\n" +
                "Tel.: " + data_user[2]);
        mTextViewSummaryGame.setText("Name: " + game_name + "\n" +
                "Price: " + game_price);
    }
}
