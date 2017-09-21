package com.will;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
    private List<Card> cards = new ArrayList<Card>();
    private String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};

    private int cardsDealt = 0;

    public void fullDeck() {
        for (String suit : suits) {
            for (int value = 1; value <= 13; value++) {
                cards.add(new Card(value, suit));
            }
        }
        cardsDealt = 0;
    }

    public void shuffle() {
        List<Card> shuffleDeck = new ArrayList<Card>(cards);
        Collections.shuffle(shuffleDeck);
        this.cards = shuffleDeck;
    }


    public int getDeckSize() {
        return this.cards.size();
    }

    public int valueOfCards() {
        int handValue = 0;
        int aces = 0;

        for (Card card : this.cards) {
            switch (card.getFaceValue()) {
                case 2:
                    handValue += 2;
                    break;
                case 3:
                    handValue += 3;
                    break;
                case 4:
                    handValue += 4;
                    break;
                case 5:
                    handValue += 5;
                    break;
                case 6:
                    handValue += 6;
                    break;
                case 7:
                    handValue += 7;
                    break;
                case 8:
                    handValue += 8;
                    break;
                case 9:
                    handValue += 9;
                    break;
                case 10:
                    handValue += 10;
                    break;
                case 11:
                    handValue += 10;
                    break;
                case 12:
                    handValue += 10;
                    break;
                case 13:
                    handValue += 10;
                    break;
                case 1:
                    aces += 1;
                    break;
            }
        }

        for (int i = 0; i < aces; i++) {
            if (handValue > 10) {
                handValue += 1;
            } else {
                handValue += 11;
            }

        }
        return handValue;
    }

//    public ArrayList<Card> getCards() {
//        return cards;
//    }



    public Card getACard(int i) {
        return this.cards.get(i);
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public void addACard(Card cardToAdd) {
        this.cards.add(cardToAdd);
    }

    public void draw(Deck fromDeck) {
        this.cards.add(fromDeck.getACard(0));
        fromDeck.removeCard(0);
    }

    public void moveCardsToDeck(Deck toDeck) {
        int thisDeckSize = this.cards.size();
        for (int i = 0; i < thisDeckSize; i++) {
            toDeck.addACard(this.getACard(i));
        }
        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }
    }

    public String toString() {
        String listDeck = "";
        int i = 0;
        for (Card card : this.cards) {
            listDeck += "\n" + card.toString();
            i++;
        }
        return listDeck;
    }

}
