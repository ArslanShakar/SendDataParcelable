package com.practice.coding.senddataparcelable;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FragmentC extends Fragment {
    private TextView tvData;

    public FragmentC() {

    }

    public static FragmentC newInstance(ArrayList<PersonModel> arrayList) {
        FragmentC fragment_c = new FragmentC();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("KEY_C", arrayList);
        fragment_c.setArguments(bundle);
        return fragment_c;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        tvData = view.findViewById(R.id.tvData);

        String data = "";
        Bundle bundle = getArguments();
        if (bundle != null) {
            ArrayList<PersonModel> personArrayList = bundle.getParcelableArrayList("KEY_C");
            for (int i = 0; i<personArrayList.size(); i++)
            {
                PersonModel model = personArrayList.get(i);
                data += model.getName()+"\n"+model.getEducation()+"\n"+model.getAge()+"\n-----\n";
            }
        }
        tvData.setText(data);
        return view;
    }
}
