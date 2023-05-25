package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Phone {
    public String color;
    protected String material;
    protected String IMEI;
    Integer BATTERY_LIFE = 24;
    public List<Contact> contactList = new ArrayList<>();
    List<String> callHistory = new ArrayList<>();
    public Map<String, List<TextMessage>> messageList = new HashMap<>();

    public Phone(String IMEI, String material, String color) {
        this.IMEI = IMEI;
        this.material = material;
        this.color = color;

    }

    public void addContact(Contact contact) {
        if (!validateContact(contact)) {
            throw new IllegalArgumentException("Contact is not validated.");
        } else
            contactList.add(contact);
    }

    /**
     * This method was in addContact, but at testing I realised I could make a separate method
     * to do just one thing.
     * Validate contact and return a boolean.
     */
    public boolean validateContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact can not be null");
        }
        if (contact.getContactId() == null || contact.getContactId().isEmpty()) {
            throw new IllegalArgumentException("Contact ID cannot be empty");
        }
        if (contact.getPhoneNumber() == null || contact.getPhoneNumber().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (contact.getLastName() == null || contact.getLastName().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (!checkingPhoneNumberFormat(contact.getPhoneNumber())) {
            throw new IllegalArgumentException("Invalid phone number format");
        } else return true;
    }

    /**
     * The checkingPhoneNumberFormat is checking for the phone number to start with 07 and have 10 digits in total.
     * A small validation for romanian numbers.
     */
    public boolean checkingPhoneNumberFormat(String phoneNumber) {
        return phoneNumber.matches("07\\d{8}");
    }

    public Contact getFirstContact() {
        if (contactList.isEmpty()) {
            throw new IllegalArgumentException("No contacts saved to our list. ");
        } else
            return contactList.get(0);
    }

    public Contact getLastContact() {
        if (contactList.size() >= 1) {
            return contactList.get(contactList.size() - 1);
        }
        throw new IllegalArgumentException("The contact list is empty");
    }

    public void seeAllExistingContacts() {
        System.out.println(contactList.toString());
    }

    public void sendTextMessage(String phoneNumber, String messageContent) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (!checkingPhoneNumberFormat(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        if (messageContent.length() >= 500) {
            throw new IllegalArgumentException("Text message has to much chars. ");
        }
        TextMessage textMessage = new TextMessage(phoneNumber, messageContent);
        List<TextMessage> messageList1 = messageList.getOrDefault(phoneNumber, new ArrayList<>());
        messageList1.add(textMessage);
        messageList.put(phoneNumber, messageList1);
        BATTERY_LIFE = BATTERY_LIFE - 1;
    }

    public String getFirstMessage(String phoneNumber) {
        List<TextMessage> messages = messageList.get(phoneNumber);
        if (messages != null && !messages.isEmpty()) {
            return messages.get(0).getContent();
        }
        throw new IllegalArgumentException("For this " + phoneNumber + " number there is no message sent.");
    }


    public String getSecondMessage(String phoneNumber) {
        List<TextMessage> messages = messageList.get(phoneNumber);
        if (messages != null && messages.size() >= 2) {
            return messages.get(1).getContent();
        }
        throw new IllegalArgumentException("For this " + phoneNumber + " number there is no second message sent.");
    }

    public List<TextMessage> getAllMessagesForSpecificContact(String phoneNumber) {
        return messageList.getOrDefault(phoneNumber, new ArrayList<>());
    }

    public void makeACall(String phoneNumber) {

        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Please dial a number.");
        }
        if (!checkingPhoneNumberFormat(phoneNumber)) {
            throw new IllegalArgumentException("Please dial a correct number");
        }
        callHistory.add(phoneNumber);
        BATTERY_LIFE = BATTERY_LIFE - 2;
    }

    public void seeAllCallHistory() {
        System.out.println("Here we have the call history: " + callHistory.toString());
    }

    public int returnBatteryLife() {
        return BATTERY_LIFE;
    }

    public String returnPhoneName() {
        return getClass().getSimpleName();
    }
    @Override
    public String toString(){
        return messageList.get(returnPhoneName()).toString();
    }
}