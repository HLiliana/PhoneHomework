package org.example;

import java.util.List;

public abstract class Samsung implements Phone {

    public String color;
    protected String material;
    protected String IMEI;
    String phoneNumber;

    public Samsung(String IMEI, String material, String color) {
        this.IMEI = IMEI;
        this.material = material;
        this.color = color;

    }


    /**
     * phoneBook has in the for of string the phone number and in the form of list te contacts.
     * <p>
     * protected Map<Phone, List<String>> phoneBook = new HashMap<>();
     */


    public abstract class Contact implements Phone{

        String phoneNumber;
        String firstName;
        String lastName;
        protected Integer contactCriteriaNumber;
        public String contact (String phoneNumber,String firstName,String lastName, Integer contactCriteriaNumber){
            this.phoneNumber=phoneNumber;
            this.firstName=firstName;
            this.lastName=lastName;
            this.contactCriteriaNumber=contactCriteriaNumber;
            return phoneNumber;
        }
        public List<Contact> contactList;

        public void addContact(Contact contact) {
            if (contact == null) {
                return;
            } else contactList.add(contact);

        }

        public void call(String phoneNumber){

            }
        public String[] sendMessage (String phoneNumber, String[] strings){
            this.phoneNumber=phoneNumber;
            if (strings.length > 100){
                System.out.println("Your message has to many characters.");
            }
            System.out.println(strings + " Message sent!");

            return strings;
        }
        public String[] getFirstMessage(String phoneNumber) {
            if (phoneNumber.equals(contactList.contains(phoneNumber))) {
                System.out.println();
                return phoneNumber.toString(
                        sendMessage(this.phoneNumber, String[0]));

            }
            return new String[0];
        }
        public String[] getSecondMessage(String phoneNumber){
                if (phoneNumber.equals(contactList.contains(phoneNumber))) {
                    System.out.println();
                    return phoneNumber.toString(
                            sendMessage(this.phoneNumber, String[1]));
                }
            return new String[0];
        }

        public void getContact(int i){
        contactList.get(contactCriteriaNumber);
        }
        public void removeContact(Contact contact) {
            contactList.remove(contact);
        }

        public List<Contact> getContacts() {

            return contactList;
        }
    }
}