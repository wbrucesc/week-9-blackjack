package com.will;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = false;

        while (gameOver == false) {
            System.out.println("Welcome to Blackjack!");
            System.out.println("=======================");

            //creates new deck, adds cards, shuffles deck
            Deck playingDeck = new Deck();
            playingDeck.fullDeck();
            playingDeck.shuffle();

            //creates a deck/hand for player and dealer
            Deck playerCards = new Deck();
            Deck dealerCards = new Deck();

            //deals 2 cards to both player and dealer
            playerCards.draw(playingDeck);
            playerCards.draw(playingDeck);

            dealerCards.draw(playingDeck);
            dealerCards.draw(playingDeck);


            while (true) {
                Scanner userInput = new Scanner(System.in);

                System.out.println("PLAYER HAS: " + playerCards.toString());
                System.out.println("PLAYER HAND IS WORTH: " + playerCards.valueOfCards());
                System.out.println("--------------------------");
                System.out.println("DEALER HAS: \n" + dealerCards.getACard(0).toString() + "\n" + "hidden card");

                //if player gets blackjack on first hand (& dealer didn't) then they win and game ends
                if ((playerCards.valueOfCards() == 21) && ((dealerCards.valueOfCards() != 21) && gameOver == false)) {
                    System.out.println("YOU GOT BLACKJACK ON THE FIRST HAND! YOU WIN!");
                    System.out.println("*************************");
                    gameOver = true;
                    break;
                }

                //if dealer gets blackjack on first hand (& player didn't) then they win and game ends
                if ((dealerCards.valueOfCards() == 21) && ((playerCards.valueOfCards() != 21) && gameOver == false)) {
                    System.out.println("DEALER GOT BLACKJACK ON THE FIRST HAND! YOU LOSE!");
                    System.out.println("*************************");
                    gameOver = true;
                    break;
                }

                System.out.println("Would you like to (1) Hit or (2) Stand?");
                String choice = userInput.nextLine();

                //player chooses to hit
                if(choice.equals("1")) {

                    playerCards.draw(playingDeck);
                    System.out.println("YOU DREW A: " + playerCards.getACard(playerCards.getDeckSize() - 1).toString());
                    System.out.println("--------------------------");

                    //player busts if value of cards > 21
                    if (playerCards.valueOfCards() > 21) {
                        System.out.println("BUST! YOUR HAND WORTH: " + playerCards.valueOfCards());
                        System.out.println("--------------------------");
                        gameOver = true;
                        break;
                    }
                    //player gets blackjack if value of cards = 21
                    if (playerCards.valueOfCards() == 21) {
                        System.out.println("*** YOU GOT BLACKJACK! YOU WIN ***");
                        System.out.println("***********************************");
                        gameOver = true;
                        break;
                    }

                }

                //player chooses to stand
                if (choice.equals("2")) {
                    break;
                }

            }

            //if stand chosen then reveal dealer's cards
            System.out.println("DEALER HAS: " + dealerCards.toString());

            //while loop for dealer to continue drawing cards while value of hand < 17
            while ((dealerCards.valueOfCards() < 17) && gameOver == false) {
                dealerCards.draw(playingDeck);
                System.out.println("DEALER DREW A: " + dealerCards.getACard(dealerCards.getDeckSize() - 1));
            }

            System.out.println("DEALER'S HAND WORTH: " + dealerCards.valueOfCards());
            System.out.println(("--------------------------"));

            //value of dealer's hand > 21 = BUST
            if ((dealerCards.valueOfCards() > 21) && gameOver == false) {
                System.out.println("DEALER BUSTS! YOU WIN");
                gameOver = true;
            }

            //value of dealer's hand > player's hand = Dealer wins
            if ((dealerCards.valueOfCards() > playerCards.valueOfCards()) && gameOver == false) {
                System.out.println("DEALER WINS");
                gameOver = true;
            }

            //value of player's hand > dealer's hand = Player wins
            if ((playerCards.valueOfCards() > dealerCards.valueOfCards()) && gameOver == false) {
                System.out.println("YOU WIN");
                gameOver = true;
            }

            //player wins game if hand has value of 21 (gets blackjack)
            if ((playerCards.valueOfCards() == 21) && gameOver == false) {
                System.out.println("*** YOU GOT BLACKJACK! ***");
                gameOver = true;
            }

            //dealer wins if hand has value of 21 (gets blackjack)
            if ((dealerCards.valueOfCards() == 21) && gameOver == false ) {
                System.out.println("*** DEALER HAS BLACKJACK! ***");
                gameOver = true;
            }

            //if value of player and dealer's hands are equal = PUSH
            if ((playerCards.valueOfCards() == dealerCards.valueOfCards()) && gameOver == false) {
                System.out.println("PUSH");
                gameOver = true;
            }

            //if gameOver is true then prints "game over" and exits program
            if (gameOver == true) {
                System.out.println("--------Game Over--------");
            }

        }

    }
}
