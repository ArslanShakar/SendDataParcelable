package com.practice.coding.senddataparcelable;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void sendData(View view )
    {
        FragmentA fragment = new FragmentA();

        PersonModel data = new PersonModel();

        String name = "Alif Arslan";
        String education = "Software Engineer";
        String age = "22 years";

        data.setName(name);
        data.setEducation(education);
        data.setAge(age);

        Bundle bundle = new Bundle();

        fragment.setArguments(bundle);
        bundle.putParcelable("KEY", data);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearLayout,fragment, "FA");
        transaction.commit();

    }

    public void sendDataWithFactoryMethod(View view) {

        /* pass data in the static method that is defined in the Fragment B,  static method access pass data & get Reference of that
        fragment
        */
        PersonModel person = new PersonModel("Arslan Shakar", "BS S.E", "Twenty Two Years");
        FragmentB fragment_b = FragmentB.newInstance(person);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearLayout,fragment_b, "B");
        transaction.commit();
    }

    public void sendArrayListData(View view) {

        String name = "Arslan Kashmiri";
        String education  = "Software Developer";
        String age = "23 - Years";

        ArrayList<PersonModel> arrayList = new ArrayList<>();

        PersonModel personA = new PersonModel();
        personA.setName(name);
        personA.setEducation(education);
        personA.setAge(age);

        PersonModel personB = new PersonModel();
        personB.setName("Ali");
        personB.setEducation("S.E");
        personB.setAge("21");

        PersonModel personC = new PersonModel();
        personC.setName("Humza");
        personC.setEducation("S.E");
        personC.setAge("22");

        arrayList.add(personA);
        arrayList.add(personB);
        arrayList.add(personC);

        FragmentC fragmentC = FragmentC.newInstance(arrayList);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearLayout, fragmentC, "C");
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
