package com.will;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        System.out.println("Welcome to Blackjack!" + "\n" + "------------------------");

        Deck playingDeck = new Deck();
        playingDeck.fullDeck();
        playingDeck.shuffle();
//        System.out.println(playingDeck.toString());



        //create player's deck/hand
        Deck playerCards = new Deck();

        //create dealer's deck/hand
        Deck dealerCards = new Deck();

        boolean gameOver = false;

        //Deal 2 cards to player
        playerCards.draw(playingDeck);
        playerCards.draw(playingDeck);
//
//
//      //Deal 2 cards to dealer
        dealerCards.draw(playingDeck);
        dealerCards.draw(playingDeck);

        if (playerCards.valueOfCards() == 21) {
            System.out.println("You got blackjack!");
        } else if (dealerCards.valueOfCards() == 21 ) {
            System.out.println("Dealer has blackjack :(");
        }

        while (true) {
            Scanner userInput = new Scanner(System.in);

            System.out.println("Player has: " + playerCards.toString());
            System.out.println("Player hand worth: " + playerCards.valueOfCards());
            System.out.println("-----------------------");
//
            System.out.println("Dealer has: " + dealerCards.getACard(0).toString() + "\n" + "hidden card");
            System.out.println("-----------------------");

            System.out.println("Would you like to (1) Hit or (2) Stand? ");
            String choice = userInput.nextLine();

            if (choice.equals("1")) {
                playerCards.draw(playingDeck);
                System.out.println("You just drew a: " + playerCards.getACard(playerCards.getDeckSize() - 1).toString());
                System.out.println("==================");

                if (playerCards.valueOfCards() > 21) {
                    System.out.println("Bust! Your hand worth: " + playerCards.valueOfCards());
                    System.out.println("========================");
                    gameOver = true;
                    break;
                }
            }

            if (choice.equals("2")) {
                break;
            }
        }

            System.out.println("Dealer's cards revealed: " + dealerCards.toString());
//            System.out.println("Dealer's hand worth: " + dealerCards.valueOfCards());



            while ((dealerCards.valueOfCards()) < 17 && gameOver == false) {
                dealerCards.draw(playingDeck);
                System.out.println("Dealer drew a: " + dealerCards.getACard(dealerCards.getDeckSize() - 1).toString());
            }

            if ((dealerCards.valueOfCards() > playerCards.valueOfCards()) && gameOver == false) {
                System.out.println("The dealer won this time! ");
                gameOver = true;
            }

            System.out.println("Dealer's hand worth: " + dealerCards.valueOfCards());
            if ((dealerCards.valueOfCards() > 21) && gameOver == false) {
                System.out.println("Dealer busts! You won!");
                gameOver = true;
            }

            if ((playerCards.valueOfCards() > dealerCards.valueOfCards()) || (playerCards.valueOfCards() == 21) && gameOver == false) {
                System.out.println("Player's hand worth: " + playerCards.valueOfCards());
                System.out.println("You won!");
                gameOver = true;
            }

//        playingDeck.getDeckSize();
//        System.out.println("Player has " + playerCards.getDeckSize() + " cards.");

//

//

//        System.out.println("Dealer has " + dealerCards.getDeckSize() + " cards.");
//
////        newDeck.dealCard();
//        System.out.println("New Deck has " + playingDeck.getDeckSize() + " cards.");
//        System.out.println(newDeck.dealCard());
//        System.out.println(newDeck.getCards());








    }
}
