import java.util.*;

public class ChatRoom
{
    private List<Person> users;

    public ChatRoom()
    {
        this.users = new ArrayList<>();
    }

    public void addUser(Person user)
    {
        users.add(user);
    }

    public Person findUserByEmail(String email)
    {
        for (Person user : users)
        {
            if (user.getEmail().equals(email))
            {
                return user;
            }
        }
        return null;
    }

    public Person findUserByName(String name)
    {
        for (Person user : users)
        {
            if (user.getUsername().equals(name))
            {
                return user;
            }
        }
        return null;
    }
}
