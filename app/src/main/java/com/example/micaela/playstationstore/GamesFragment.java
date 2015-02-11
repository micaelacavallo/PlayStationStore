package com.example.micaela.playstationstore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class GamesFragment extends ListFragment {

    EditText mSearchGame;
    String[] mGamesNames;
    ArrayAdapter<String> mAdapter;
    private ArrayList<String> mArraySort = new ArrayList<>();

    private static final String ASSASINS_CREED = "Assassin's Creed Rogue";
    private static final String BATMAN = "Batman: Arkham City";
    private static final String BATTLEFIELD = "Battlefield 4";
    private static final String CALL_OF_DUTY = "Call of Duty: Advanced Warfare";
    private static final String DARK_SOULS = "Dark Souls II";
    private static final String DESTINY = "Destiny";
    private static final String FAR_CRY = "Far Cry 4";
    private static final String GOD_OF_WAR = "God of War III";
    private static final String GTA = "Grand Theft Auto V";
    private static final String MIDDLE_EARTH = "Middle-earth: Shadow of Mordor";
    private static final String MORTAL_KOMBAT = "Mortal Kombat X";
    private static final String STREET_FIGHTER = "Street Fighter IV";
    private static final String THE_LAST_OF_US = "The Last of Us";
    private static final String RESIDENT_EVIL = "Resident Evil 6";
    private static final String UNCHARTED = "Uncharted 3: Drake's Deception";


    public GamesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);
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
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String gameName = parent.getItemAtPosition(position).toString();

                switch (gameName){
                    case ASSASINS_CREED:
                        loadFragment(new AssassinsCreedGameFragment());
                        break;
                    case BATMAN:
                        loadFragment(new BatmanGameFragment());
                        break;
                    case BATTLEFIELD:
                        loadFragment(new BattlefieldGameFragment());
                        break;
                    case CALL_OF_DUTY:
                        loadFragment(new CallOfDutyGameFragment());
                        break;
                    case DARK_SOULS:
                        loadFragment(new DarkSoulsGameFragment());
                        break;
                    case DESTINY:
                        loadFragment(new DestinyGameFragment());
                        break;
                    case FAR_CRY:
                        loadFragment(new FarCryGameFragment());
                        break;
                    case GOD_OF_WAR:
                        loadFragment(new GodOfWarGameFragment());
                        break;
                    case GTA:
                        loadFragment(new GranTheftAutoGameFragment());
                        break;
                    case MIDDLE_EARTH:
                        loadFragment(new MiddleEarthGameFragment());
                        break;
                    case MORTAL_KOMBAT:
                        loadFragment(new MortalKombatGameFragment());
                        break;
                    case STREET_FIGHTER:
                        loadFragment(new StreetFighterGameFragment());
                        break;
                    case THE_LAST_OF_US:
                        loadFragment(new TheLastOfUsGameFragment());
                        break;
                    case RESIDENT_EVIL:
                        loadFragment(new ResidentEvilGameFragment());
                        break;
                    case UNCHARTED:
                        loadFragment(new UnchartedGameFragment());
                        break;
                }
            }
        });
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

    private void loadFragment (Object object)
    {
        getFragmentManager().beginTransaction().
                replace(R.id.container, (Fragment) object).
                addToBackStack(null).
                commit();
    }
}
