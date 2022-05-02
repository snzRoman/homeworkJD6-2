import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private HashMap<String, List<Contact>> phoneBook = new HashMap<>();

    public void setContactList(String groupName, List<Contact> contacts) {
        phoneBook.put(groupName, contacts);
    }

    public void addNewContact(String groupName, Contact contact){
        if (phoneBook.containsKey(groupName)){
            List<Contact> list = phoneBook.get(groupName);
            list.add(contact);
            phoneBook.put(groupName, list);
        }else{
            List<Contact> list = new ArrayList<>();
            list.add(contact);
            phoneBook.put(groupName, list);
        }
    }

    public void addNewContact(String[] groupName, Contact contact){
        for (int i = 0; i < groupName.length; i++) {
            this.addNewContact(groupName[i], contact);
        }
    }

    public HashMap<String, List<Contact>> getPhoneBook(){
        return phoneBook;
    }

    public List<Contact> searchGroupContact(String groupName){
        return phoneBook.get(groupName);
    }

    public Contact searchPhoneNumber(String phoneNumber){
        for(Map.Entry<String, List<Contact>> map : phoneBook.entrySet()){
            for(Contact contact : map.getValue()){
                if (contact.getPhoneNumber().equals(phoneNumber)){
                    return contact;
                }
            }
        }
        return null;
    }
}
