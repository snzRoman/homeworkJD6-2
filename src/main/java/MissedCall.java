import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedCall {

    private Map<LocalDateTime, String> missedCall = new TreeMap<>();

    public void printMissedCalls(PhoneBook phoneBook){
        for (Map.Entry<LocalDateTime, String> map : missedCall.entrySet()) {
            Contact contact = phoneBook.searchPhoneNumber(map.getValue());
            if (contact == null){
                System.out.println(map.getKey() + " - " + map.getValue());
            }else{
                System.out.println(map.getKey() + " - " + contact.getContactName());
            }
        }
    }

    public void printAllMissedCall(){
        for (Map.Entry<LocalDateTime, String> map: missedCall.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }

        System.out.println();
    }

    public void addMissedCall(LocalDateTime localDateTime, String number){
        missedCall.put(localDateTime, number);
    }
}
