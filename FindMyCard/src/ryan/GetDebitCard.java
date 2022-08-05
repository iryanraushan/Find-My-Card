package ryan;

import java.util.Scanner;

public class GetDebitCard {

    DebitCardFound debitCardFoundList;
    static Scanner input = new Scanner(System.in);

    public class CardFounderDetails {
        public String nameOfFounder;
        public String contactNumberOfFounder;

        CardFounderDetails(String nameOfFounder, String contactNumberOfFounder) {
            this.nameOfFounder = nameOfFounder;
            this.contactNumberOfFounder = contactNumberOfFounder;
        }
    }

    private class DebitCardFound extends CardFounderDetails {
        private String cardNumber;
        private String nameOnCard;
        private DebitCardFound nextCard;

        DebitCardFound(String nameOnCard, String cardNumber, String nameOfFounder, String contactNumber) {
            super(nameOfFounder, contactNumber);
            this.cardNumber = cardNumber;
            this.nameOnCard = nameOnCard;
            this.nextCard = null;
        }
    }

    public void addFoundCardList(String nameOnCard, String cardNumber, String nameOfFounder, String contactNumber) {
        DebitCardFound newCard = new DebitCardFound(nameOnCard, cardNumber, nameOfFounder, contactNumber);

        if (debitCardFoundList == null) {
            debitCardFoundList = newCard;
            return;
        }
        DebitCardFound temp = debitCardFoundList;
        while (temp.nextCard != null) {
            temp = temp.nextCard;
        }
        temp.nextCard = newCard;

        return;
    }

    public void printFoundCardList() {
        System.out.println("List of found card : ");
        DebitCardFound temp = debitCardFoundList;

        if (temp == null) {
            System.out.println("No list found");
            return;
        }

        while (temp != null) {
            System.out.println("Name On Card : " + temp.nameOnCard);
            System.out.println("Card number : " + temp.cardNumber);
            System.out.println("Founder Name : " + temp.nameOfFounder);
            System.out.println("Contact number of founder : " + temp.contactNumberOfFounder);
            System.out.println();
            System.out.println();
            temp = temp.nextCard;
        }
        return;
    }

    public boolean showStatus(String name, String cardNumber) {

        String[] details = checkPresent(name, cardNumber);

        if (details[2] != null) {
            System.out.println();
            System.out.println();
            System.out.println("Get Person name : " + details[0]);
            System.out.println("Contact NUmber : " + details[1]);
            System.out.println("PLEASE CONTACT TO THIS PERSON FOR THIS CARD.");
            System.out.println();
            System.out.println();
            return true;
        }
        else{
            System.out.println("Your card details is not found in my database.\n");
            return false;
        }
    }

    public String[] checkPresent(String name, String cardNumber) {

        DebitCardFound temp = debitCardFoundList;
        
        String[] details = new String[3];

        if (temp == null) {
            return details;
        }

        while (temp != null) {

            if (name.equals(temp.nameOnCard) && cardNumber.equals(temp.cardNumber)) {
                details[0] = temp.nameOfFounder;
                details[1] = temp.contactNumberOfFounder;
                details[2] = " ";
                return details;
            }
            temp = temp.nextCard;
        }
        return details;
    }
}