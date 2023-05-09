package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Phone {
    public String color;
    protected String material;
    protected String IMEI;

    public Phone(String IMEI, String material, String color) {
        this.IMEI = IMEI;
        this.material = material;
        this.color = color;

    }

    Integer BATTERY_LIFE = 24;
    public List<String> contactList = new ArrayList<>();
    List<String> callHistory = new ArrayList<>();
    List<String> messageHistoryForSpecificPhoneNumber = new ArrayList<>();
    public Map<String, List<String>> messageList = new HashMap<>();

    public void addContact(Contact contact) {
        contactList.add(contact.toString());
    }

    public String getFirstContact() {
        return contactList.get(0);
    }

    public String getLastContact() {
        return contactList.get(contactList.size() - 1);
    }

    public void seeAllExistingContacts() {
    }

    public void sendTextMessage(String phoneNumber, String textMessage) {
        if (textMessage.length() < 500) {
            messageHistoryForSpecificPhoneNumber.add(textMessage);
            BATTERY_LIFE = BATTERY_LIFE - 1;
        }
        messageList.put(phoneNumber, messageHistoryForSpecificPhoneNumber);
    }

    public String getFirstMessage(String phoneNumber) {
        for (Map.Entry<String, List<String>> messageList : messageList.entrySet()) {
            if (messageList.getKey() == phoneNumber) {
                return messageHistoryForSpecificPhoneNumber.get(0);
            }
        }
        return null;
    }


    public String getSecondMessage(String phoneNumber) {
        for (Map.Entry<String, List<String>> messageList : messageList.entrySet()) {
            if (messageList.getKey() == phoneNumber) {
                return messageHistoryForSpecificPhoneNumber.get(1);
            }
        }
        return null;
    }

    public void seeAllMessagesForSpecificContact(String phoneNumber) {
        for (String key : messageList.keySet()) {
            if (key == phoneNumber) {
                List<String> textMessagePerPhoneNumber = new ArrayList<>();
                textMessagePerPhoneNumber.add(messageList.get(phoneNumber).toString());
                System.out.println("This are all the message send to this phone number: "
                        + phoneNumber + textMessagePerPhoneNumber);
            }
        }
    }

    public void makeACall(String phoneNumber) {
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
}