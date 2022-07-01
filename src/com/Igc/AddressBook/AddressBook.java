package com.Igc.AddressBook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    ArrayList<Contact> addressBookList = new ArrayList<>();

    public void addContact() {
        Contact contact = new Contact();
        System.out.println("Enter the First Name:");
        contact.setFirstName(sc.next());
        if(checkContact(contact.getFirstName())) {
            System.out.println("Contact is Already Exist.");
        } else {
            System.out.println("Enter the Last Name:");
            contact.setLastName(sc.next());
            System.out.println("Enter the Address:");
            contact.setAddress(sc.next());
            System.out.println("Enter the City Name:");
            contact.setCity(sc.next());
            System.out.println("Enter the State Name:");
            contact.setState(sc.next());
            System.out.println("Enter the Zip No:");
            contact.setZip(sc.next());
            System.out.println("Enter the Phone Number:");
            contact.setPhoneno(sc.next());
            System.out.println("Enter the Email Id:");
            contact.setEmailId(sc.next());
            addressBookList.add(contact);
        }
    }

    public boolean checkContact(String firstname) {
        boolean flag = false;
        for (int i = 0; i < addressBookList.size(); i++) {
            Contact contact = addressBookList.get(i);
            if (firstname.equalsIgnoreCase(contact.getFirstName())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void displayContact() {
        try {
//            for (int i = 0; i < addressBookList.size(); i++) {
//                Contact contact = addressBookList.get(i);
//                System.out.println(contact.toString());
//            }
            addressBookList.stream().filter(contact -> contact.getCity().equalsIgnoreCase("Shahada")).forEach(contact-> System.out.println(contact.toString()));
        } catch (NullPointerException np) {
            System.out.println("Contact Not Exist !!");
        }
    }

    public void editContact() {
        System.out.println("***EDIT CONTACT***");
        System.out.println("Enter Name to check the Contact:");
        String name = sc.next();
        boolean found = false;
        Contact contact = null;
        for (int i = 0; i < addressBookList.size(); i++) {
            contact = addressBookList.get(i);
            if (name.equalsIgnoreCase(contact.getFirstName())) {
                found = true;
            }
        }
        if (found) {
            System.out.println("Enter the Last Name:");
            contact.setLastName(sc.next());
            System.out.println("Enter the Address:");
            contact.setAddress(sc.next());
            System.out.println("Enter the City Name:");
            contact.setCity(sc.next());
            System.out.println("Enter the State Name:");
            contact.setState(sc.next());
            System.out.println("Enter the Zip No:");
            contact.setZip(sc.next());
            System.out.println("Enter the Phone Number:");
            contact.setPhoneno(sc.next());
            System.out.println("Enter the Email Id:");
            contact.setEmailId(sc.next());
        } else {
            System.out.println("Contact Not Matched !!");
        }
    }
    public void deleteContact(){
        System.out.println("Enter the First Name to Delete the Contact : ");
        String name = sc.next();
        for(int i = 0; i < addressBookList.size(); i++) {
            Contact contact = addressBookList.get(i);
            if(name.equalsIgnoreCase(contact.getFirstName())) {
                System.out.println("Contact Found.And Contact Deleted.");
                addressBookList.remove(i);
            } else {
                System.out.println("Contact Not Found.");
            }
        }
        displayContact();
    }
    public void checkFoundPerson(){
        System.out.println("Enter the City Name to Count Person : ");
        String name = sc.next();
        int count=0;
        for (int i=0 ; i < addressBookList.size(); i++)
        {
            Contact contact = addressBookList.get(i);
            if (name.equalsIgnoreCase(contact.getCity())){
                count++;
            }
        }
        System.out.println("Total Person From "+name+" : "+count);
    }

    public void addressBookMenu() {
        //AddressBook addressBook = new AddressBook();
        int choice;
        do {
            System.out.println("\n**WELCOME TO ADDRESS BOOK MENU**");
            System.out.println("1.ADD NEW CONTACT\n2.EDIT CONTACT\n3.SHOW CONTACT\n4.DELETE CONTACT\n5.COUNT CONTACT FROM CITY\n6.EXIT");
            System.out.println("Enter your choice :");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    displayContact();
                    break;
                case 4:
                        deleteContact();
                       // addressBook.displayContact();
                    break;
                case 5:
                    checkFoundPerson();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid Choice No..!");
                    break;
            }
            // System.out.println("Arraylist Size: "+addressBook.addressBookList.size());

        } while (choice != 6);

    }
}
