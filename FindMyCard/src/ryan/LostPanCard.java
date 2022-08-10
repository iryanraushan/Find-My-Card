package ryan;

import java.util.*;

public class LostPanCard {

    PanCardLose panCardLoseList;
    static Scanner input = new Scanner(System.in);

    class CardLoserDetails {
        private String nameOfLoser;
        private String contactNumberOfLoser;

        CardLoserDetails(String nameOfLoser, String contactNumberOfLoser) {
            this.nameOfLoser = nameOfLoser;
            this.contactNumberOfLoser = contactNumberOfLoser;
        }

        public String getNameOfLoser() {
            return nameOfLoser;
        }

        public String getContactNumberOfLoser() {
            return contactNumberOfLoser;
        }

    }

    private class PanCardLose extends CardLoserDetails {
        private String cardNumber;
        private String nameOnCard;
        private PanCardLose nextCard;

        PanCardLose(String nameOnCard, String cardNumber, String contactNumber) {
            super(nameOnCard, contactNumber);
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

    public void addLostCardList(String nameOnCard, String cardNumber, String contactNumber) {
        PanCardLose newCard = new PanCardLose(nameOnCard, cardNumber, contactNumber);

        if (panCardLoseList == null) {
            panCardLoseList = newCard;
            return;
        }
        PanCardLose temp = panCardLoseList;
        while (temp.nextCard != null) {
            temp = temp.nextCard;
        }
        temp.nextCard = newCard;
        return;
    }

    public void printLoseCardList() {
        System.out.println("List of Lost card : ");
        PanCardLose temp = panCardLoseList;

        if (temp == null) {
            System.out.println("No list found");
            return;
        }

        while (temp != null) {
            System.out.println("Name On Card : " + temp.getNameOnCard());
            System.out.println("PAN Card number : " + temp.getCardNumber());
            System.out.println("Contact number : " + temp.getContactNumberOfLoser());
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
            System.out.println("This PAN card is belong to : " + details[0]);
            System.out.println("Contact NUmber : " + details[1]);
            System.out.println("PLEASE CONTACT TO THIS PERSON FOR THIS PAN CARD.");
            System.out.println();
            System.out.println();
            return true;
        }

        else {
            System.out.println("This PAN card is not found in my database.");
            return false;
        }

    }

    public String[] checkPresent(String name, String cardNumber) {

        PanCardLose temp = panCardLoseList;
        String[] details = new String[3];

        if (temp == null) {
            return details;
        }

        while (temp != null) {

            if (name.equals(temp.nameOnCard) && cardNumber.equals(temp.cardNumber)) {

                details[0] = temp.getNameOfLoser();
                details[1] = temp.getContactNumberOfLoser();
                details[2] = "t ";
                return details;
            }
            temp = temp.nextCard;
        }
        return details;
    }

}