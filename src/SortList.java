import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Great Esmidth on 2016/2/7.
 * Stay Foolish
 */
public class SortList implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		User u1 = (User) o1;
		User u2 = (User) o2;

		int flag = u1.getAge().compareTo(u2.getAge());
		if(flag == 0)
		{
			return u1.getName().compareTo(u2.getName());
		}
		else
		{
			return flag;
		}
	}
	public static void main(String[] args)
	{
		List<User> userList = new ArrayList<User>();
		userList.add(new User("dd","4"));
		userList.add(new User("aa","1"));
		userList.add(new User("ee","5"));
		userList.add(new User("bb","2"));
		userList.add(new User("ff","5"));
		userList.add(new User("cc","3"));
		userList.add(new User("gg","6"));

		Comparator<User> comparator = new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				User u1 = (User) o1;
				User u2 = (User) o2;

				int flag = u1.getAge().compareTo(u2.getAge());
				if(flag == 0)
				{
					return u1.getName().compareTo(u2.getName());
				}
				else
				{
					return flag;
				}
			}
		};
		Collections.sort(userList,comparator);

		for (int i =0;i < userList.size();i++)
		{
			User user_temp = (User)userList.get(i);
			System.out.println(user_temp.getAge()+","+user_temp.getName());
		}
	}

}

class User {
	String name;
	String age;

	public User(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {

		return name;
	}

	public String getAge() {
		return age;
	}
}