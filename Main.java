/*
 * Create two or more accounts using the Register option. You can register with a username, email, and password.
 * Then, log in with your email and password.
 * After logging in, you have two options: view messages and send messages.
 * In the View Messages option, you can see the messages and their senders.
 * In the Send Messages option, you can send messages to others who have an account.
 * You can also logout from the account.
 * You can also exit the application.
 */

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ChatRoom chatRoom = new ChatRoom();

    public static void main(String[] args)
    {

        System.out.println();
        System.out.println();
        System.out.println("\t\t\t\tWELCOME TO TALKIFY..");
        System.out.println();


        while (true)
        {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("\t\t\t\t1. REGISTER");
            System.out.println();
            System.out.println("\t\t\t\t2. LOGIN");
            System.out.println();
            System.out.println("\t\t\t\t0. EXIT");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println();

            int choice = scanner.nextInt();
            System.out.println();
            scanner.nextLine(); 

            switch (choice)
            {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("\t\tEXITING APPLICATION...");
                    System.out.println();
                    scanner.close();
                    return;
                default:
                    System.out.println();
                    System.out.println("\t\tINVALID CHOICE, PLEASE TRY AGAIN...");
                    System.out.println();
            }
        }
    }

    private static void registerUser()
    {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("ENTER USERNAME : ");
        String username = scanner.nextLine();
        System.out.println();

        System.out.print("ENTER EMAIL : ");
        String email = scanner.nextLine();
        System.out.println();

        System.out.print("ENTER PASSWORD : ");
        String password = scanner.nextLine();
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------------");

        Person newUser = new Person(username, email, password);
        chatRoom.addUser(newUser);

        System.out.println();
        System.out.println("\t\t\tREGISTRATION SUCCESSFUL FOR " + username);
        System.out.println();
    }

    private static void loginUser()
    {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.print("ENTER EMAIL : ");
        String email = scanner.nextLine();
        System.out.println();

        System.out.print("ENTER PASSWORD : ");
        String password = scanner.nextLine();
        System.out.println();

        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------------");

        Person loggedInUser = chatRoom.findUserByEmail(email);

        if (loggedInUser != null && loggedInUser.login(email, password))
        {
            System.out.println();
            System.out.println("\t\tLOGIN SUCCESSFULL. WELCOME " + loggedInUser.getUsername() + "!");
            System.out.println();
            handleUserActions(loggedInUser);
        }
        else
        {
            System.out.println();
            System.out.println("\t\tLOGIN FAILED, PLEASE CHECK THE EMAIL AND PASSWORD...");
            System.out.println();
        }
    }

    private static void handleUserActions(Person user)
    {
        while (true)
        {
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println();
            System.out.println("1. SEND MESSAGE :");
            System.out.println();

            System.out.println("2. VIEW MESSAGE :");
            System.out.println();

            System.out.println("0. LOGOUT :");
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    sendMessage(user);
                    break;
                case 2:
                    user.viewMessages();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("\t\t\tLOGGING OUT...");
                    System.out.println();
                    return;
                default:
                    System.out.println();
                    System.out.println("\t\tINVALID CHOICE. PLEASE TRY AGAIN...");
                    System.out.println();
            }
        }
    }

    private static void sendMessage(Person sender)
    {
        System.out.println();
        System.out.print("ENTER RECIPIENT'S NAME : ");
        String recipientName = scanner.nextLine();
        System.out.println();
        Person recipient = chatRoom.findUserByName(recipientName);

        if (recipient == null)
        {
            System.out.println();
            System.out.println("\t\t\tRECIPIENT NOT FOUND...");
            return;
        }

        System.out.print("ENTER MESSAGE : ");
        String message = scanner.nextLine();


        sender.sendMessage(recipient, message);
        System.out.println();
        System.out.println("\t\tMESSAGE SENT SUCCESSFULLY...");
        System.out.println();
    }
}