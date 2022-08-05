package ryan;

import java.util.*;


public class LostDebitCard {
    DebitCardLose debitCardLoseList;
    static Scanner input = new Scanner(System.in);

    class CardLoserDetails {
        String nameOfLoser;
        String contactNumberOfLoser;

        CardLoserDetails(String nameOfLoser, String contactNumberOfLoser) {
            this.nameOfLoser = nameOfLoser;
            this.contactNumberOfLoser = contactNumberOfLoser;
        }
    }

    private class DebitCardLose extends CardLoserDetails {
        private String cardNumber;
        private String nameOnCard;
        private DebitCardLose nextCard;

        DebitCardLose(String nameOnCard, String cardNumber, String contactNumber) {
            super(nameOnCard, contactNumber);
            this.cardNumber = cardNumber;
            this.nameOnCard = nameOnCard;
            this.nextCard = null;
        }
    }

    public void addLostCardList(String nameOnCard, String cardNumber, String contactNumber) {
        DebitCardLose newCard = new DebitCardLose(nameOnCard, cardNumber, contactNumber);

        if (debitCardLoseList == null) {
            debitCardLoseList = newCard;
            return;
        }
        DebitCardLose temp = debitCardLoseList;
        while (temp.nextCard != null) {
            temp = temp.nextCard;
        }
        temp.nextCard = newCard;
        return;
    }

    public void printLoseCardList() {
        System.out.println("List of Lost card : ");
        DebitCardLose temp = debitCardLoseList;

        if (temp == null) {
            System.out.println("No list found");
            return;
        }

        while (temp != null) {
            System.out.println("Name On Card : " + temp.nameOnCard);
            System.out.println("Card number : " + temp.cardNumber);
            System.out.println("Contact number : " + temp.contactNumberOfLoser);
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
            System.out.println("This card is belong to : " + details[0]);
            System.out.println("Contact NUmber : " + details[1]);
            System.out.println("PLEASE CONTACT TO THIS PERSON FOR THIS CARD.");
            System.out.println();
            System.out.println();
            return true;
        }

        else {
            System.out.println("This card is not found in my database.");
            return false;
        }

    }

    public String[] checkPresent(String name, String cardNumber) {

        DebitCardLose temp = debitCardLoseList;
        String[] details = new String[3];

        if (temp == null) {
            return details;
        }


        while (temp != null) {

            if (name.equals(temp.nameOnCard) && cardNumber.equals(temp.cardNumber)) {

                details[0] = temp.nameOfLoser;
                details[1] = temp.contactNumberOfLoser;
                details[2] = "t ";
                return details;
            }
            temp = temp.nextCard;
        }
        return details;
    }

}