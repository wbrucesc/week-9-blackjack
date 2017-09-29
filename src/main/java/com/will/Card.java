package com.will;

public class Card {
    private int faceValue;
    private String suit;

    public Card(int faceValue, String suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    //switch that assigns string value based on a card's facevalue
    public String getValueAsAString() {
        switch (faceValue) {
            case 1: return "Ace";
            case 2: return "2";
            case 3: return "3";
            case 4: return "4";
            case 5: return "5";
            case 6: return "6";
            case 7: return "7";
            case 8: return "8";
            case 9: return "9";
            case 10: return "10";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return "not valid";
        }


    }

    public String toString() {
        return this.getValueAsAString() + " - " + this.suit.toString();
    }
}
