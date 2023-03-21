package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Phone {
    protected String manufacturers;
    protected String[] messageContent = new String[500];
    int batteryLife = 24;
    protected String color;
    protected String material;
    protected String IMEI;
    protected List<Integer> callHistory = new ArrayList<>();
    public List<String> contactList = new ArrayList<>();
    protected Integer contactCriteriaNumber;
    String phoneNumber;
    String firstName;
    String lastName;

    public void addContact(Integer contactCriteriaNumber, String phoneNumber, String firstName, String lastName) {
        this.contactCriteriaNumber = contactCriteriaNumber;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void SeeExistingContacts(){
    }
    public void getFirstContact() {
        if (contactCriteriaNumber == 1){

        }

    }

    public void getLastContact() {
    }

    public int sendMessage(String phoneNumber, String[] messageContent) {
        this.phoneNumber = phoneNumber;
        this.messageContent = messageContent;
        batteryLife = batteryLife-1;
        System.out.println(batteryLife);
        return batteryLife;
    }

    public void getFirstMessage(String phoneNumber) {
        this.phoneNumber= phoneNumber;
    }

    public void getSecondMessage(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String viewHistory() {
        for (int i=1; i<100; i++){
            callHistory.add(i);
        }
        return callHistory.toString();
    }

    public int call(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        batteryLife = batteryLife-2;
        System.out.println(batteryLife);
        return batteryLife;
    }
}
