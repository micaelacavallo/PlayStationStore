package com.example.micaela.playstationstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ListOfGamesFragment extends ListFragment {

    EditText mSearchGame;
    String[] mGamesNames;
    ArrayAdapter<String> mAdapter;
    private ArrayList<String> mArraySort = new ArrayList<>();

    public ListOfGamesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_of_games, container, false);
        prepareEditTextSearchGame(rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareListView();
    }

    private void prepareListView() {
        mGamesNames = getActivity().getResources().getStringArray(R.array.games);
        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mGamesNames);
        setListAdapter(mAdapter);

    }

    private void prepareEditTextSearchGame(View rootView) {
        mSearchGame = (EditText) rootView.findViewById(R.id.edit_text_search_game);
        mSearchGame.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int textlength = mSearchGame.getText().length();
                mArraySort.clear();
                for (int i = 0; i < mGamesNames.length; i++) {
                    if (textlength <= mGamesNames[i].length()) {
                        if (mSearchGame.getText().toString().equalsIgnoreCase((String) mGamesNames[i].subSequence(0, textlength))) {
                            mArraySort.add(mGamesNames[i]);
                        }
                    }
                }
                mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mArraySort);
                setListAdapter(mAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
