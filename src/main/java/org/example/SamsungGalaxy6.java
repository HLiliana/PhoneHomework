package org.example;

import java.util.List;

public class SamsungGalaxy6 extends Samsung{

    public SamsungGalaxy6( String IMEI, String material, String color) {
        super( IMEI, material, color);


    }

    @Override
    public List<String> addContact(Integer contactCriteriaNumber, String phoneNumber, String firstName, String lastName) {
        return null;
    }

    @Override
    public String[] sendMessage(String s, String[] strings) {

    }

    @Override
    public String[] getFirstMessage(String phoneNumber) {

    }
}
