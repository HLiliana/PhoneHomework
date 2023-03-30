package org.example;

import java.util.*;

interface Phone {

    public List<String> addContact(Integer contactCriteriaNumber, String phoneNumber, String firstName, String lastName);

    void call(String phoneNumber);
    String[] sendMessage(String s, String[] strings);

    String[] getFirstMessage(String phoneNumber);
    String [] getSecondMessage(String phoneNumber);

    void getContact(int i);




//    public int call(String phoneNumber);
//
//    public void getSecondMessage(String phoneNumber);
//
//    public void getFirstMessage(String phoneNumber);
//
//    public int sendMessage(String phoneNumber, String[] messageContent);
//
//    public void getLastContact();
//
//    public void getFirstContact();
//
//    public void SeeExistingContacts();
//

//    public void setContactList();
}

