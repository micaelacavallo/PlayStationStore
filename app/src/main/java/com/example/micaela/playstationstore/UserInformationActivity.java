package com.example.micaela.playstationstore;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.preference.PreferenceFragment;


public class UserInformationActivity extends Activity {
    public static class UserInformationFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.user_information_settings);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        getFragmentManager().beginTransaction().replace(R.id.settings, new UserInformationFragment()).commit();

    }
}

