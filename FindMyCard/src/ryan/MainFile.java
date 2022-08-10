package ryan;

import java.util.*;

public class MainFile {

    static Scanner input = new Scanner(System.in);
    static GetDebitCard debitCardFound = new GetDebitCard();
    static LostDebitCard debitCardLose = new LostDebitCard();

    static GetPanCard panCardFound = new GetPanCard();
    static LostPanCard panCardLose = new LostPanCard();

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
        debitCardFound.printFoundCardList();
        debitCardLose.printLoseCardList();
        panCardFound.printFoundCardList();
        panCardLose.printLoseCardList();
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
        System.out.println("2. Pan Card.");
        // System.out.println("2. Aadhaar Card.");
        System.out.println("4. Back to home page.");
        int option = input.nextInt();
        switch (option) {
            case 1:
                addDetailsOfLostDebitCard();
                break;

            case 2:
                addDetailsOfLostPanCard();
                break;

            case 4:
                return;
        }

    }

    private static void cardList2() {
        System.out.println("Which type of card did you get ?");

        System.out.println("1. ATM Card.");
        System.out.println("2. Pan Card.");
        // System.out.println("2. Aadhaar Card.");
        System.out.println("4. Back to home page.");

        int option = input.nextInt();
        switch (option) {
            case 1:
                addDetailsOfGotDebitCard();
                break;

            case 2:
                addDetailsOfGotPanCard();
                break;

            case 4:
                return;
        }
    }

    // Function for adding details of Lost debit card.
    public static void addDetailsOfLostDebitCard() {

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

        Boolean status = debitCardFound.showStatus(nameOnCard, cardNumber);

        if (!status) {
            String contactNumber;
            do {
                System.out.print("Enter 10 digit of contact number : ");
                contactNumber = input.next();
                if (contactNumber.length() == 10) {
                    break;
                }
            } while (true);

            debitCardLose.addLostCardList(nameOnCard, cardNumber, contactNumber);
            System.out.println("%%%~~THANK YOU FOR CHOOSING OUR SERVICES~~%%%");
        }
    }

    // Function for adding details of found debit card.
    public static void addDetailsOfGotDebitCard() {

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
        Boolean status = debitCardLose.showStatus(nameOnCard, cardNumber);

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

            debitCardFound.addFoundCardList(nameOnCard, cardNumber, nameOfFounder, contactNumber);
            System.out.println("Keep the card with you. They will contact to you soon.");
            System.out.println("%%%~~THANK YOU FOR HELPING OTHERS~~%%%");
        } else {
            return;
        }
    }

    // function for adding Details of lost PAN card.
    public static void addDetailsOfLostPanCard() {

        input.nextLine();
        System.out.print("Enter name as per card : ");
        String nameOnCard = input.nextLine();
        nameOnCard = nameOnCard.toUpperCase();

        String cardNumber;
        do {
            System.out.print("Enter 10 digit of PAN number : ");
            cardNumber = input.next();
            cardNumber = cardNumber.toUpperCase();
            if (cardNumber.length() == 10) {

                if (cardNumber.charAt(3) == 'P' || cardNumber.charAt(3) == 'C' || cardNumber.charAt(3) == 'H'
                        || cardNumber.charAt(3) == 'A' || cardNumber.charAt(3) == 'B' || cardNumber.charAt(3) != 'G'
                        || cardNumber.charAt(3) == 'J' || cardNumber.charAt(3) == 'L' || cardNumber.charAt(3) == 'F'
                        || cardNumber.charAt(3) == 'T') {

                    if (nameOnCard.charAt(0) == cardNumber.charAt(4)) {
                        break;
                    } else {
                        System.out.println("Invalid input of 5th character.");
                        System.out.println("Try again .....");
                        continue;
                    }
                } else {
                    System.out.println("Invalid input of 4th character.");
                    System.out.println("Try again .....");
                }
            }

        } while (true);

        Boolean status = panCardFound.showStatus(nameOnCard, cardNumber);

        if (!status) {
            String contactNumber;
            do {
                System.out.print("Enter 10 digit of contact number : ");
                contactNumber = input.next();
                if (contactNumber.length() == 10) {
                    break;
                }
            } while (true);

            panCardLose.addLostCardList(nameOnCard, cardNumber, contactNumber);
            System.out.println("%%%~~THANK YOU FOR CHOOSING OUR SERVICES~~%%%");
        }
    }

    // function for adding Details of found PAN card.
    public static void addDetailsOfGotPanCard() {

        input.nextLine();
        System.out.print("Enter name as per card : ");
        String nameOnCard = input.nextLine();
        nameOnCard = nameOnCard.toUpperCase();

        String cardNumber;
        do {
            System.out.print("Enter 10 digit of PAN number : ");
            cardNumber = input.next();
            cardNumber = cardNumber.toUpperCase();

            if (cardNumber.length() == 10) {

                if (cardNumber.charAt(3) == 'P' || cardNumber.charAt(3) == 'C' || cardNumber.charAt(3) == 'H'
                        || cardNumber.charAt(3) == 'A' || cardNumber.charAt(3) == 'B' || cardNumber.charAt(3) != 'G'
                        || cardNumber.charAt(3) == 'J' || cardNumber.charAt(3) == 'L' || cardNumber.charAt(3) == 'F'
                        || cardNumber.charAt(3) == 'T') {

                    if (nameOnCard.charAt(0) == cardNumber.charAt(4)) {
                        break;
                    } else {
                        System.out.println("Invalid input of 5th character.");
                        System.out.println("Try again .....");
                        continue;
                    }
                } else {
                    System.out.println("Invalid input of 4th character.");
                    System.out.println("Try again .....");
                }
            }

        } while (true);

        input.nextLine();
        Boolean status = panCardLose.showStatus(nameOnCard, cardNumber);

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

            panCardFound.addFoundCardList(nameOnCard, cardNumber, nameOfFounder, contactNumber);
            System.out.println("Keep the card with you. They will contact to you soon.");
            System.out.println("%%%~~THANK YOU FOR HELPING OTHERS~~%%%");
        } else {
            return;
        }
    }

}
