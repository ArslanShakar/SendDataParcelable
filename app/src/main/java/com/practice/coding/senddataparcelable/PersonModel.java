package com.practice.coding.senddataparcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonModel implements Parcelable {
    private String name, education, age;


    public PersonModel() {
        //Constructor necessary when implementing a parcerable interface..
    }

    public PersonModel(String name, String education, String age) {
        this.name = name;
        this.education = education;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    protected PersonModel(Parcel in) {
        name = in.readString();
        education = in.readString();
        age = in.readString();
    }

    public static final Creator<PersonModel> CREATOR = new Creator<PersonModel>() {
        @Override
        public PersonModel createFromParcel(Parcel in) {
            return new PersonModel(in);
        }

        @Override
        public PersonModel[] newArray(int size) {
            return new PersonModel[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(education);
        dest.writeString(age);
    }
}
