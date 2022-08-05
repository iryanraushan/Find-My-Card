package ryan;

import java.util.*;

public class MainFile {

    static Scanner input = new Scanner(System.in);
    static GetDebitCard cardFound = new GetDebitCard();
    static LostDebitCard cardLose = new LostDebitCard();

    public static void main(String[] args) {

        do {
            System.out.println("Do you want to continue your application : ");
            System.out.println("1 for continue and 0 for exit");
            int choice = input.nextInt();
            if (choice == 0) {
                break;
            }
            start();
        } while (true);
        cardFound.printFoundCardList();
        cardLose.printLoseCardList();
    }

    private static void start() {
        System.out.println("1. Have you lost the card ?");
        System.out.println("2. Have you found the card ?");
        System.out.println("3. Back to home page.");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                cardList1();
                break;
            case 2:
                cardList2();
                break;
            case 3:
                return;
        }
    }

    private static void cardList1() {
        System.out.println("Which type of card did you lose ?");

        System.out.println("1. ATM Card.");
        // System.out.println("2. Aadhaar Card.");
        // System.out.println("3. Pan Card.");
        System.out.println("4. Back to home page.");
        int option = input.nextInt();
        switch (option) {
            case 1:
                addDetailsOfLostCard();
                break;
            case 4:
                return;
        }

    }

    private static void cardList2() {
        System.out.println("Which type of card did you get ?");

        System.out.println("1. ATM Card.");
        // System.out.println("2. Aadhaar Card.");
        // System.out.println("3. Pan Card.");
        System.out.println("4. Back to home page.");

        int option = input.nextInt();
        switch (option) {
            case 1:
                addDetailsOfGotCard();
                break;
            case 4:
                return;
        }
    }

    public static void addDetailsOfLostCard() {

        input.nextLine();
        System.out.print("Enter name as per card : ");
        String nameOnCard = input.nextLine();
        nameOnCard = nameOnCard.toUpperCase();

        String cardNumber;
        do {
            System.out.print("Enter last 6 digit of Card number : ");
            cardNumber = input.next();
            if (cardNumber.length() == 6) {
                break;
            }
        } while (true);
 
        Boolean status = cardFound.showStatus(nameOnCard, cardNumber);

        if (!status) {
            String contactNumber;
            do {
                System.out.print("Enter 10 digit of contact number : ");
                contactNumber = input.next();
                if (contactNumber.length() == 10) {
                    break;
                }
            } while (true);

            cardLose.addLostCardList(nameOnCard, cardNumber, contactNumber );
            System.out.println("%%%~~THANK YOU FOR CHOOSING OUR SERVICES~~%%%");
        }
    }

    public static void addDetailsOfGotCard() {

        input.nextLine();
        System.out.print("Enter name as per card : ");
        String nameOnCard = input.nextLine();
        nameOnCard = nameOnCard.toUpperCase();

        String cardNumber;
        do {
            System.out.print("Enter last 6 digit of Card number : ");
            cardNumber = input.next();
            if (cardNumber.length() == 6) {
                break;
            }
        } while (true);

        input.nextLine();
        Boolean status = cardLose.showStatus(nameOnCard, cardNumber);

        if (!status) {
            System.out.print("Enter Your Name : ");
            String nameOfFounder = input.nextLine();
            nameOfFounder = nameOfFounder.toUpperCase();

            String contactNumber;
            do {
                System.out.print("Enter 10 digit of contact number : ");
                contactNumber = input.next();
                if (contactNumber.length() == 10) {
                    break;
                }
            } while (true);

            cardFound.addFoundCardList(nameOnCard, cardNumber, nameOfFounder, contactNumber);
            System.out.println("Keep the card with you. They will contact to you soon.");
            System.out.println("%%%~~THANK YOU FOR HELPING OTHERS~~%%%");
        }
        else {
            return;
        }
    }
}
