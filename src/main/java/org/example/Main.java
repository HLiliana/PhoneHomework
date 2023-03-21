package org.example;

import java.util.ArrayList;
import java.util.List;

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
 * properties that are configurable: color, material // color , material
 * properties that are instance specific: IMEI // IMEI
 *
 * Behavior
 *
 * a message can have maximum 500 chars
 * every time a message is send an hour is taken from the battery life
 * every time a call is made two hours are taken from the battery life
 *
 * NOUNS: contact, phone, text message, call history, manufacturers, model, battery, color, material, IMEI
 * Verbs: create, see(existing contacts), send, see (all messages), make(a call), see(call history)
 *
 * Class : Phone, Model
 */
public class Main
{
    public static void main( String[] args )
    {

  //      Phone phone= new Samsung(); // shouldn't compile

        Phone phone = new SamsungGalaxy6();
        Phone phone1 = new SamsungGalaxyA23();

        phone.addContact(1, "0736073207", "Hetea", "Liliana");

        phone.addContact(2, "0740022033", "Pop", "Maria");

        phone1.addContact(1, "0741122133", "Ionescu", "Ioan");

        phone1.addContact(2, "0752233244", "Rus", "Ana");

        System.out.println("SamsungGalaxy6 color is ".concat(phone.color = "Green")
                            + " and the material used is ".concat(phone.material = "Stainless Steel"));
        System.out.println("SamsungGalaxyA23 color is ".concat(phone1.color = "White")
                            + " and the material used is ".concat(phone.material = "Recycled Plastic"));
        System.out.println(phone.IMEI = "124578124578124" + phone.toString());
        System.out.println(phone1.IMEI = "235689235689235" + phone1.toString());

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

        phone.getFirstMessage("phone number");

        phone.getSecondMessage("phone number");

// make a call to the second contact from the previously listed

        phone1.call(phone1.phoneNumber);

        System.out.println(phone.viewHistory());
    }
}
