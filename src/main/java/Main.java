import java.time.LocalDateTime;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Contact contact1 = new Contact("Petya", "89678889977");
        Contact contact2 = new Contact("Vasya", "89515554466");
        Contact contact3 = new Contact("Anya", "89645421234");
        Contact contact4 = new Contact("Sveta", "89652153124");
        Contact contact5 = new Contact("Olya", "89996664411");
        Contact contact6 = new Contact("Brother", "81112223355");
        Contact contact7 = new Contact("Mother", "89876543210");
        Contact contact8 = new Contact("Evlampiy Petrovich", "89996666666");
        Contact contact9 = new Contact("Avtoservice", "88009505050");

        PhoneBook phoneBook = new PhoneBook();

        List<Contact> list1 = new ArrayList<>();
        list1.add(contact1);
        list1.add(contact2);
        list1.add(contact3);
        phoneBook.setContactList("coworkers", list1);

        List<Contact> list2 = new ArrayList<>();
        list2.add(contact3);
        list2.add(contact4);
        list2.add(contact5);
        phoneBook.setContactList("friends", list2);

        List<Contact> list3 = new ArrayList<>();
        list3.add(contact6);
        list3.add(contact7);
        list3.add(contact8);
        phoneBook.setContactList("family", list3);

        List<Contact> list4 = new ArrayList<>();
        list4.add(contact9);

        phoneBook.setContactList("services", list4);

        phoneBook.addNewContact(new String[]{"family", "services"}, new Contact("phone service", "81112223344"));

        MissedCall missedCall = new MissedCall();
        missedCall.addMissedCall(LocalDateTime.now(), "81112223344");
        Thread.sleep(1000);
        missedCall.addMissedCall(LocalDateTime.now(), "89678889977");
        Thread.sleep(1000);
        missedCall.addMissedCall(LocalDateTime.now(), "89546542565");
        Thread.sleep(1000);
        missedCall.addMissedCall(LocalDateTime.now(), "87549658465");
        Thread.sleep(1000);
        missedCall.addMissedCall(LocalDateTime.now(), "89652153124");
        Thread.sleep(1000);
        missedCall.addMissedCall(LocalDateTime.now(), "89876543210");

        missedCall.printAllMissedCall();
        missedCall.printMissedCalls(phoneBook);
    }

    public static void printPhoneBook(Map<String, List<Contact>> map){

        for (Map.Entry<String, List<Contact>> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}