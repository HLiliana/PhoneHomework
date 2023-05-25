package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneTest extends TestCase {

    @Test
    public void testAddContact() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        Contact contact2 = new Contact("2", "0755444666", "Ana", "Pop");
        phone.addContact(contact1);
        phone.addContact(contact2);
        assertEquals(2, phone.contactList.size());
    }

    @Test
    public void testAddContactWithNullOrEmptyId() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.addContact(new Contact("",
                        "0775889224", "Hetea", "Liliana")));

    }

    @Test
    public void testAddContactWithNullOrEmptyFirstName() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.addContact(new Contact("1",
                        "0775889224", null, "Liliana")));

    }

    @Test
    public void testAddContactWithNullOrEmptyLastName() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.addContact(new Contact("1",
                        "0775889224", "Hetea", "")));

    }

    @Test
    public void testAddContactWithNullOrEmptyPhoneNumber() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.addContact(new Contact("1",
                        null, "Hetea", "Liliana")));

    }

    @Test
    void testAddContactPhoneNumberFormat() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.addContact(new Contact("1",
                        "07885", "Hetea", "Liliana")));
    }

    @Test
    public void testMakeACallHistorySize() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        phone.makeACall(contact1.phoneNumber);
        phone.makeACall(contact1.phoneNumber);
        assertEquals(2, phone.callHistory.size());
    }

    @Test
    public void testAddANullContact() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.addContact(null));
    }

    @Test
    public void testMakeACallToNullContact() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = null;
//this test is not working
        assertThrows(IllegalArgumentException.class,
                () -> phone.makeACall(contact1.phoneNumber));
    }

    @Test
    public void testMakeACallToNullPhoneNumber() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", null, "Liliana", "Hetea");

        assertThrows(IllegalArgumentException.class,
                () -> phone.makeACall(contact1.phoneNumber));
    }

    @Test
    public void testMakeACallToPhoneNumberFormatIncorrect() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "03258", "Liliana", "Hetea");

        assertThrows(IllegalArgumentException.class,
                () -> phone.makeACall(contact1.phoneNumber));
    }

    @Test
    public void testGetFirstMessage() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        assertEquals("Hey, just wanted to say HY in my first message.", phone.getFirstMessage(contact1.phoneNumber));
    }

    @Test
    public void testGetSecondMessage() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        phone.sendTextMessage(contact1.phoneNumber,
                "Hey, just wanted to say HY in my first message.");
        assertEquals("Hey, just wanted to say HY in my first message.", phone.getSecondMessage(contact1.phoneNumber));
    }

    @Test
    void getFirstContactFromEmptyList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.getFirstContact());
    }

    @Test
    void getLastContactFromEmptyList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.getFirstContact());
    }

    @Test
    void getLastContactFromList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        assertEquals(contact1, phone.getFirstContact());
    }

    @Test
    void sendTextMessage() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        phone.sendTextMessage(contact1.phoneNumber, "Hello world! ");
        assertEquals(1, phone.messageList.size());
    }

    @Test
    void sendTextMessageToNullPhoneNumber() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.sendTextMessage(null, "Hello world!"));
    }

    @Test
    void sendTextMessageToIncorrectFormatPhoneNumber() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");

        assertThrows(IllegalArgumentException.class,
                () -> phone.sendTextMessage("256402", "Hello world!"));
    }

    @Test
    void sendTextMessageWithNullContent() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        phone.sendTextMessage("0720203507", null);
//with "" is working with null is not
        assertEquals(1, phone.messageList.size());
    }

    @Test
    void getFirstMessageFromAnEmptyList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        assertThrows(IllegalArgumentException.class,
                () -> phone.getFirstMessage(contact1.phoneNumber));
    }

    @Test
    void getFirstMessageFromAnList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        phone.sendTextMessage(contact1.phoneNumber, "Hello world!");
//test does not work,
//bad implementation of @toString()
        assertEquals(phone.messageList.values().toString()
                , phone.getFirstMessage(contact1.phoneNumber));
    }

    @Test
    void getSecondMessageFromEmptyList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        assertThrows(IllegalArgumentException.class,
                () -> phone.getFirstMessage(contact1.phoneNumber));
    }

    @Test
    void getSecondMessageFromList() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        phone.sendTextMessage(contact1.phoneNumber, "haha");
        phone.sendTextMessage(contact1.phoneNumber, "haha blabala");
//test does not work,
//bad implementation of @toString()
        assertEquals(phone.messageList.values().toString(),
                phone.getSecondMessage(contact1.phoneNumber));
    }

    @Test
    void returnBatteryLife() {
        Phone phone = new SamsungGalaxy6("1251251251251", "plastic", "grey");
        Contact contact1 = new Contact("1", "0777111111", "Liliana", "Hetea");
        phone.addContact(contact1);
        phone.makeACall(contact1.phoneNumber);
        phone.sendTextMessage(contact1.phoneNumber, "Hello world!");
        assertEquals(21, phone.returnBatteryLife());
    }

}