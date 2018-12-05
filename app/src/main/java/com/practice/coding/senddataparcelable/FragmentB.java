package com.practice.coding.senddataparcelable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Person;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    private TextView tvData;

    //Factory method most likely use fragment itself manage their communication
    public static FragmentB newInstance(PersonModel person)
    {
        FragmentB fragmentB = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_B", person);

        fragmentB.setArguments(bundle);

        return fragmentB;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        tvData = view.findViewById(R.id.tvData);

        String data = "";
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            PersonModel personModel = bundle.getParcelable("KEY_B");

            data += personModel.getName()
                    +"\n"+
                    personModel.getEducation()
                    +"\n"+
                    personModel.getAge();
        }

        tvData.setText(data);
        return view;
    }
}
