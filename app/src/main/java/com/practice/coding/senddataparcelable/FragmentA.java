package com.practice.coding.senddataparcelable;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private TextView tvData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        tvData = view.findViewById(R.id.tvData);

        String data = "";
        Bundle bundle = getArguments();
        if(bundle != null)
        {
            PersonModel person = bundle.getParcelable("KEY");
            data = data + person.getName()+"\n" + person.getEducation()+"\n"+person.getAge();
        }

        tvData.setText(data);
        return view;
    }
}
