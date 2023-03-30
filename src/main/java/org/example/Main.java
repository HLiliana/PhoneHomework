package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *DESCRIPTION
 *
 * create an application based on the following requirements
 * All Phones offer the following behavior:
 *
 * you can create new contacts (as separate properties - create 2 contacts per phone) // create , contacts , phone
 * you can see existing contacts // see existing contacts
 * you can send a text message // send , text message
 * you can see all messages for a specific contact // see all messages
 * (as separate properties - create 2 messages per contact)
 * you can make a call // make a call
 * you can see all calls history // see all , calls history
 *
 * Implement a hierarchy of Phone classes where:
 *
 * a Phone can be of certain manufacturers and // manufacturers
 * it can have a specific model (Phone - Samsung - SamsungGalaxyS6) // specific model
 * properties which cannot change: battery life (in number of hours) // battery life
 *
 * Behavior
 *
 * a message can have maximum 500 chars
 * every time a message is send an hour is taken from the battery life
 * every time a call is made two hours are taken from the battery life
 *
 * implement the classes, abstract classes and interfaces according to the given information
 * create at least 2 phone brands with 2 models for each
 * create 2 new contacts
 * send a message to the first contact
 * make a call to the second contact
 *
 * NOUNS: contact, phone, text message, call history, manufacturers, model, battery, color, material, IMEI
 * Verbs: create, see(existing contacts), send, see (all messages), make(a call), see(call history)
 *
 * Class : Phone, Brand/Manufactures, Model
 */
public class Main {
    public static void main(String[] args) {

        //      Phone phone= new Samsung(); // shouldn't compile

        Phone phone = new SamsungGalaxy6("124578124578124", "Stainless Steel", "Green");
        Phone phone1 = new SamsungGalaxyA23("235689124578125", "Recycled Plastic", "White");


        System.out.println("First phone added is a SamsungGalaxy6 " + phone.toString());
        System.out.println("Second phone added is a SamsungGalaxyA23" + phone1.toString());

        Map<Phone, List<String>> phoneBook = new HashMap<>();

        Phone phone3 = new SamsungGalaxyA23("123", "Steel", "Gry");

        List<String> contact = new ArrayList<>();

        contact.add(phone3.addContact(2, "0740022033",
                "Pop", "Maria").toString());
        contact.add(phone3.addContact(1, "0741122133",
                "Ionescu", "Ioan").toString());
        contact.add(phone3.addContact(2, "0752233244",
                "Rus", "Ana").toString());

        phoneBook.put(phone3, contact);

        List<String> contactList = phoneBook.get(contact);
        for(String contacts : contactList){
            System.out.println(contacts);
        }
        System.out.println(phoneBook);


        phone1.addContact(1, "0741122133", "Ionescu", "Ioan");

        phone1.addContact(2, "0752233244", "Rus", "Ana");

        phone.sendMessage("0755258963", new String[]{"jndhfbcbybfhfjsns"});
        phone.sendMessage("0740022033", new String[]{"alanajficcdsbcyrfbkjashbscjdcufrfbdnc"});

        phone.call(phone.phoneNumber);

        System.out.println(phone.getContact(0));
        System.out.println(phone.getContact(1));

        phone.getFirstContact(0);

        phone.getLastContact(1);

// send a message to the first contact from the previously listed

// max number of characters - 100

        phone.sendMessage("phone number", new String[]{"message content"});

        phone.getFirstMessage("0740022033");

        phone.getSecondMessage("phone number");

// make a call to the second contact from the previously listed

        phone1.call(phone1.phoneNumber);

        System.out.println(phone.viewHistory());
    }
}
