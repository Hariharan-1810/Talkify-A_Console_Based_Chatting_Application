import java.util.*;

public class Person
{
    private String username;
    private String email;
    private String password;
    private List<String> messages;

    public Person(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.messages = new ArrayList<>();
    }

    public String getEmail()
    {
        return email;
    }

    public boolean login(String email, String password)
    {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void sendMessage(Person recipient, String message)
    {
        recipient.receiveMessage(message, this);
    }

    private void receiveMessage(String message, Person sender)
    {
        String formattedMessage = sender.getUsername() + " : " + message + "\n";
        messages.add(formattedMessage);
    }

    public void viewMessages()
    {
        if (messages.isEmpty())
        {
            System.out.println();
            System.out.println("\t\t\tNO NEW MESSAGES...");
            System.out.println();
        }
        else
        {
            System.out.println();
            System.out.println("\t\t\tRECEIVED MESSAGES :");
            System.out.println();
            for (String message : messages)
            {
                System.out.println(message);
                System.out.println();
            }
            messages.clear();
        }
    }

    public String getUsername()
    {
        return username;
    }
}
