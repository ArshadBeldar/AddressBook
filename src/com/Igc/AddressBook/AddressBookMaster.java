package com.Igc.AddressBook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AddressBookMaster {

    static Scanner sc = new Scanner(System.in);
    Map<String,AddressBook> addressBookMap = new HashMap<>();

    public void addAddressBook() {
        System.out.println("Enter the Address Name : ");
        String addressbookName = sc.next();
        AddressBook addressBook = new AddressBook();
        addressBookMap.put(addressbookName,addressBook);
    }

    public void displayAddressBook() {
        System.out.println(addressBookMap.keySet());
    }

    public void selectAddressBook() {
        displayAddressBook();
        System.out.println("Enter the Address Book Name to Select : ");
        String addressBookName = sc.next();
        AddressBook addressBook = addressBookMap.get(addressBookName);
        addressBook.addressBookMenu();
    }

    public void backupAddressBook() {
        try {
            String contactData = "";
            for (String key : addressBookMap.keySet()) {
               //System.out.println(key);
                Path filePath = Paths.get(key + ".txt");
                AddressBook addressBook = addressBookMap.get(key);
                for (Contact contact : addressBook.addressBookList) {
                    contactData = contactData + "\n" + contact.getFirstName() + "," + contact.getLastName() + "," + contact.getAddress() +
                            "," + contact.getCity() + "," + contact.getState() + "," + contact.getZip() + "," +
                            contact.getPhoneno() + "," + contact.getEmailId();
                }
                byte[] data = contactData.getBytes();
                Files.write(filePath, data);
                contactData = "";
            }
        } catch (IOException ioe) {}
    }
    public void restoreAddressBook() {
        System.out.println("Enter the Addressbook Name to Restore : ");
        String addressBookName = sc.next();
        try {
            BufferedReader br = new BufferedReader(new FileReader(addressBookName+".txt"));
            String line;
            AddressBook addressBook = new AddressBook();
            while((line = br.readLine())!=null) {
                System.out.println(line);
                String[] contacData = line.split(",");
                Contact contact = new Contact(contacData[0],contacData[1],contacData[2],contacData[3],contacData[4],contacData[5],contacData[6],contacData[7]);
//                contact.setFirstName(contacData[0]);
//                contact.setLastName(contacData[1]);
//                contact.setAddress(contacData[2]);
//                contact.setCity(contacData[3]);
//                contact.setState(contacData[4]);
//                contact.setZip(contacData[5]);
//                contact.setPhoneno(contacData[6]);
//                contact.setEmailId(contacData[7]);
                addressBook.addressBookList.add(contact);
            }
            addressBookMap.put(addressBookName,addressBook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void backupToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbookmanagerdb","root","");
            Statement stmt=con.createStatement();

            System.out.println("Enter the Address Book Name to BackUP in Database : ");
            String addressbookName = sc.next();
            AddressBook addressBook = addressBookMap.get(addressbookName);
            for(Contact contact : addressBook.addressBookList) {
                stmt.executeUpdate("insert into addressbook_shop values('"+contact.getFirstName()+"','"+contact.getLastName()+"','"+contact.getAddress()+"','"+contact.getCity()+"','"+contact.getState()+"','"+contact.getZip()+"','"+contact.getPhoneno()+"','"+contact.getEmailId()+"')");
                System.out.println("Contact Saved...");
            }
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        int choice;
        AddressBookMaster addressBookMaster = new AddressBookMaster();
        do {
            System.out.println("*** ADDRESS BOOK MANAGER ***");
            System.out.println("1. ADD NEW ADDRESS BOOK \n2. EDIT ADDRESS BOOK \n3. DISPLAY ADDRESS BOOK " +
                            "\n4. SELECT ADDRESS BOOK \n5. BACKUP TO FILE \n6. RESTORE FROM FILE \n7. BACKUP TO DATABASE \n8. EXIT");
            System.out.println("Enter the Operation No : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBookMaster.addAddressBook();
                    break;
                case 2:
                    break;
                case 3:
                    addressBookMaster.displayAddressBook();
                    break;
                case 4:
                    addressBookMaster.selectAddressBook();
                    break;
                case 5:
                    addressBookMaster.backupAddressBook();
                    break;
                case 6:
                    addressBookMaster.restoreAddressBook();
                    break;
                case 7:
                    addressBookMaster.backupToDB();
                    break;
                default:
                    System.out.println("Invalid Operation No : ");
                    break;
            }
        }while(choice != 8);
    }

}
