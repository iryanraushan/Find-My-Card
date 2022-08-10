package ryan;

import java.util.Scanner;

public class GetPanCard {

    PanCardFound panCardFoundList;
    static Scanner input = new Scanner(System.in);

    public class CardFounderDetails {
        private String nameOfFounder;
        private String contactNumberOfFounder;

        CardFounderDetails(String nameOfFounder, String contactNumberOfFounder) {
            this.nameOfFounder = nameOfFounder;
            this.contactNumberOfFounder = contactNumberOfFounder;
        }

        public String getNameOfFounder() {
            return nameOfFounder;
        }

        public String getContactNumberOfFounder() {
            return contactNumberOfFounder;
        }
    }

    private class PanCardFound extends CardFounderDetails {
        private String cardNumber;
        private String nameOnCard;
        private PanCardFound nextCard;

        PanCardFound(String nameOnCard, String cardNumber, String nameOfFounder, String contactNumber) {
            super(nameOfFounder, contactNumber);
            this.cardNumber = cardNumber;
            this.nameOnCard = nameOnCard;
            this.nextCard = null;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public String getNameOnCard() {
            return nameOnCard;
        }
    }

    public void addFoundCardList(String nameOnCard, String cardNumber, String nameOfFounder, String contactNumber) {
        PanCardFound newCard = new PanCardFound(nameOnCard, cardNumber, nameOfFounder, contactNumber);

        if (panCardFoundList == null) {
            panCardFoundList = newCard;
            return;
        }
        PanCardFound temp = panCardFoundList;
        while (temp.nextCard != null) {
            temp = temp.nextCard;
        }
        temp.nextCard = newCard;

        return;
    }

    public void printFoundCardList() {
        System.out.println("List of found card : ");
        PanCardFound temp = panCardFoundList;

        if (temp == null) {
            System.out.println("No list found");
            return;
        }

        while (temp != null) {
            System.out.println("Name On Card : " + temp.getNameOnCard());
            System.out.println("PAN Card number : " + temp.getCardNumber());
            System.out.println("Founder Name : " + temp.getNameOfFounder());
            System.out.println("Contact number of founder : " + temp.getContactNumberOfFounder());
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
        } else {
            System.out.println("Your card details is not found in my database.\n");
            return false;
        }
    }

    public String[] checkPresent(String name, String cardNumber) {

        PanCardFound temp = panCardFoundList;

        String[] details = new String[3];

        if (temp == null) {
            return details;
        }

        while (temp != null) {

            if (name.equals(temp.nameOnCard) && cardNumber.equals(temp.cardNumber)) {
                details[0] = temp.getNameOfFounder();
                details[1] = temp.getContactNumberOfFounder();
                details[2] = " ";
                return details;
            }
            temp = temp.nextCard;
        }
        return details;
    }
}