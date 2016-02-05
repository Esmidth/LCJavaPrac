import junit.framework.*;
/**
 * Created by Esmidth on 2015/11/25.
 * Stay Hungry, Stay Foolish.
 */
public class Contact implements Comparable<Contact>{
    private String email;
    public Contact(String emailAddress) {
        email = emailAddress;
    }
    @Override
    public int compareTo(Contact o) {
        return 0;
    }
    public static void main(String[] args)
    {
        Contact x = new Contact("FUCKING");
        Contact y = new Contact("FUCK");
        x.compareTo(y);
    }
}
