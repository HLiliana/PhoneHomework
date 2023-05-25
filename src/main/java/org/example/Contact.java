package org.example;

public class Contact {
    public String contactId;
    public String phoneNumber;
    public String firstName;
    public String lastName;

    public Contact(String contactId, String phoneNumber, String firstName, String lastName) {
        this.contactId = contactId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "ID: " + contactId + ", Full name: " + firstName + " " + lastName + ", number: " + phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
