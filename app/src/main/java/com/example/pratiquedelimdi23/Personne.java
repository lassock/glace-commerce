package com.example.pratiquedelimdi23;

import android.os.Parcel;
import android.os.Parcelable;

public class Personne implements Parcelable {
    private   String nomproprisetaire;
    private   String lieuproprisetaire;
    private   String phoneproprisetaire;
    private   String descriptionproprisetaire;


    public Personne(String nomproprisetaire,String lieuproprisetaire,String phoneproprisetaire,String descriptionproprisetaire) {
        this.nomproprisetaire = nomproprisetaire;
        this.lieuproprisetaire=lieuproprisetaire;
        this.phoneproprisetaire = phoneproprisetaire;
        this.descriptionproprisetaire = descriptionproprisetaire;

    }

    public String getNomproprisetaire() {
        return nomproprisetaire;
    }
    public String getLieuproprisetaire() {
        return lieuproprisetaire;
    }
    public String getPhoneproprisetaire() {
        return phoneproprisetaire;
    }
    public String getDescriptionproprisetaire() {
        return descriptionproprisetaire;
    }


    protected Personne(Parcel in) {
        nomproprisetaire = in.readString();
        lieuproprisetaire = in.readString();
       phoneproprisetaire= in.readString();
        descriptionproprisetaire = in.readString();
    }

    public static final Creator<Personne> CREATOR = new Creator<Personne>() {
        @Override
        public Personne createFromParcel(Parcel in) {
            return new Personne(in);
        }

        @Override
        public Personne[] newArray(int size) {
            return new Personne[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomproprisetaire);
        parcel.writeString(lieuproprisetaire);
        parcel.writeString(phoneproprisetaire);
        parcel.writeString(descriptionproprisetaire);
    }
}
