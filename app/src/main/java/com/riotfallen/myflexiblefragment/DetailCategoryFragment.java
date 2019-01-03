package com.riotfallen.myflexiblefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailCategoryFragment extends Fragment implements View.OnClickListener {

    public static String EXTRA_NAME = "extraName";

    public DetailCategoryFragment() {}

    TextView textViewCategoryName;
    TextView textViewCategoryDescription;
    Button buttonProfile;
    Button buttonDialog;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewCategoryName = view.findViewById(R.id.textViewCategoryName);
        textViewCategoryDescription = view.findViewById(R.id.textViewCategoryDescription);
        buttonDialog = view.findViewById(R.id.buttonShowDialog);
        buttonProfile = view.findViewById(R.id.buttoProfile);

        buttonProfile.setOnClickListener(this);
        buttonDialog.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttoProfile){
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);

        } else if(v.getId() == R.id.buttonShowDialog){
            OptionDialogFragment optionDialogFragment = new OptionDialogFragment();

            FragmentManager fragmentManager = getChildFragmentManager();
            optionDialogFragment.show(fragmentManager, OptionDialogFragment.class.getSimpleName());
        }

    }

    OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show();
        }
    };
}
