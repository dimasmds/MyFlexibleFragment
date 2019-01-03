package com.riotfallen.myflexiblefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {


    Button buttonChoose, buttonClose;
    RadioGroup radioGroupOption;
    RadioButton radioButtonSaf, radioButtonMou, radioButtonLvg, radioButtonMoyes;
    OnOptionDialogListener  optionDialogListener;



    public OptionDialogFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_option_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonChoose = view.findViewById(R.id.buttonChoose);
        buttonClose = view.findViewById(R.id.buttonClose);
        radioGroupOption = view.findViewById(R.id.radioGroupOption);
        radioButtonSaf = view.findViewById(R.id.radioButtonSaf);
        radioButtonMou = view.findViewById(R.id.radioButtonMou);
        radioButtonLvg = view.findViewById(R.id.radioButtonLvg);
        radioButtonMoyes = view.findViewById(R.id.radioButtonMoyes);

        buttonClose.setOnClickListener(this);
        buttonChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonClose:
                getDialog().cancel();
                break;

            case R.id.buttonChoose:
                int checkedRadionButtonId = radioGroupOption.getCheckedRadioButtonId();
                if(checkedRadionButtonId != -1){
                    String coach = null;
                    switch (checkedRadionButtonId){
                        case R.id.radioButtonSaf:
                            coach = radioButtonSaf.getText().toString().trim();
                            break;
                        case R.id.radioButtonMou:
                            coach = radioButtonMou.getText().toString().trim();
                            break;
                        case R.id.radioButtonLvg:
                            coach = radioButtonLvg.getText().toString().trim();
                            break;
                        case R.id.radioButtonMoyes:
                            coach = radioButtonMoyes.getText().toString().trim();
                            break;
                    }

                    if(optionDialogListener != null){
                        optionDialogListener.onOptionChosen(coach);
                    }

                    getDialog().dismiss();
                }

                break;

        }
    }

    public interface OnOptionDialogListener {
        void onOptionChosen(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        if(fragment instanceof DetailCategoryFragment){
            DetailCategoryFragment detailCategoryFragment = (DetailCategoryFragment) fragment;
            this.optionDialogListener = detailCategoryFragment.optionDialogListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogListener = null;
    }
}
