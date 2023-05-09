package org.example;

import junit.framework.TestCase;

public class PhoneTest extends TestCase {

    public void testAddContact() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        Contact contact2 = new Contact("2", "0755444666", "Ana", "Pop");
        phone.addContact(contact1);
        phone.addContact(contact2);
        assertEquals(2, phone.contactList.size());
    }

    public void testGetFirstMessage() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        assertEquals("Hey, just wanted to say HY in my first message.", phone.getFirstMessage(contact1.phoneNumber));
    }

    public void testGetSecondMessage() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        assertEquals("Hey, just wanted to say HY in my first message.", phone.getSecondMessage(contact1.phoneNumber));
    }

    public void testMakeACall() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        phone.makeACall(contact1.phoneNumber);
        phone.makeACall(contact1.phoneNumber);
        assertEquals(2, phone.callHistory.size());
    }


}