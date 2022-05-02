import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    public void createPhoneBook(){
        Contact contact1 = new Contact("Petya", "89678889977");
        Contact contact2 = new Contact("Vasya", "89515554466");
        Contact contact3 = new Contact("Anya", "89645421234");
        Contact contact4 = new Contact("Sveta", "89652153124");
        Contact contact5 = new Contact("Olya", "89996664411");
        Contact contact6 = new Contact("Brother", "81112223355");
        Contact contact7 = new Contact("Mother", "89876543210");
        Contact contact8 = new Contact("Evlampiy Petrovich", "89996666666");
        Contact contact9 = new Contact("Avtoservice", "88009505050");

        phoneBook = new PhoneBook();

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


    }

    @Test
    public void searchPhoneNumberTest(){
        String phoneNumber = "81112223355";
        Contact resultContact = phoneBook.searchPhoneNumber(phoneNumber);
        Contact exceptedContact = new Contact("Brother", "81112223355");
        Assertions.assertEquals(exceptedContact, resultContact);

        //Hamcrest
        /*assertThat(exceptedContact, is(equalTo(resultContact)));*/
    }

    //Hamcrest
    @Test
    public void addNewContactTest(){
        Contact contact = new Contact("Avtoservice", "88009505050");
        phoneBook.addNewContact("Car", contact);
        assertThat(phoneBook.getPhoneBook(), hasKey("Car"));

    }

    @Test
    public void nullPhoneNumberTest(){
        String phoneNumber = "00000000000";
        Assertions.assertNull(phoneBook.searchPhoneNumber(phoneNumber));

//        Hamcrest
//        assertThat(phoneBook.searchPhoneNumber(phoneNumber), is(nullValue()));
    }

    @Test
    public void searchGroupContactTest(){
        List<Contact> list = phoneBook.searchGroupContact("coworkers");
        Assertions.assertEquals(list.size(), 3);
//        Hamcrest
//        assertThat(phoneBook.searchGroupContact("coworkers"), hasSize(3));
    }

    //Hamcrest
    @Test
    public void testContactBean(){
        Contact contact = new Contact("Avtoservice", "88009505050");
        assertThat(contact, Matchers.<Contact>hasProperty("phoneNumber"));
        assertThat(contact, Matchers.<Contact>hasProperty("contactName"));
    }



}
