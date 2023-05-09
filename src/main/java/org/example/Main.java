package org.example;

/**
 * DESCRIPTION
 * <p>
 * create an application based on the following requirements
 * All Phones offer the following behavior: // phones, behavior
 * <p>
 * you can create new contacts (as separate properties - create 2 contacts per phone) // createNewContacts
 * you can see existing contacts //seeExistingContacts
 * you can send a text message //sendTextMessage
 * you can see all messages for a specific contact (as separate properties - create 2 messages per contact)
 * // seeAllMessagesForSpecificContact
 * you can make a call // makeACall
 * you can see all calls history //seeAllCallsHistory
 * <p>
 * Implement a hierarchy of Phone classes where:
 * <p>
 * a Phone can be of certain manufacturers and have a specific model (Phone - Samsung - SamsungGalaxyS6)
 * //manufactures , specificModel
 * properties which cannot change: battery life (in number of hours) // BATTERY_LIFE
 * properties that are configurable: color, material// color, material
 * properties that are instance specific: IMEI // IMEI
 * <p>
 * Behavior
 * <p>
 * a message can have maximum 500 chars // textMessage, max500Chars
 * every time a message is sent an hour is taken from the battery life // sendMessage() batteryLife =- 1;
 * every time a call is made two hours are taken from the battery life// makeACall() batteryLife =- 2;
 * <p>
 * <p>
 * Tasks
 * <p>
 * implement the classes, abstract classes and interfaces according to the given information
 * create at least 2 phone brands with 2 models for each
 * create 2 new contacts
 * send a message to the first contact
 * make a call to the second contact
 * <p>
 * Nouns:phones, behavior, manufactures , specificModel, BATTERY_LIFE, color, material, IMEI, textMessage,
 * Verbs:  createNewContacts, seeExistingContacts, sendTextMessage, seeAllMessagesForSpecificContact,
 * makeACall, seeAllCallsHistory,
 */
public class Main {
    public static void main(String[] args) {

        //Phone phone= new Samsung(); // shouldn't compile

        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Samsung phone1 = new SamsungGalaxyA23("5215215215215", "aluminum", "black");

        Phone phone2 = new Apple14MAX("9659659659659", "plastic", "green");
        Apple phone3 = new Apple13PRO("7547587587458", "plastic", "black");

        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        Contact contact2 = new Contact("2", "0755444666", "Ana", "Pop");

        phone.addContact(contact1);
        phone.addContact(contact2);

        phone.getFirstContact();
        phone.getLastContact();

        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, I just wanted to say GOODBYE in my second message.");
        phone.getFirstMessage(contact1.phoneNumber);
        phone.getSecondMessage(contact1.phoneNumber);
        phone.seeAllMessagesForSpecificContact(contact1.phoneNumber);

        phone.makeACall(contact2.phoneNumber);
        phone.makeACall(contact1.phoneNumber);
        phone.makeACall("0777555111");
        phone.makeACall("0777999111");
        phone.seeAllCallHistory();

        System.out.println(phone.returnPhoneName() + " has " + phone.returnBatteryLife() + " hours left from it`s battery.");
    }
}