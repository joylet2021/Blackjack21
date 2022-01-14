package com.example.Blackjack21.services;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;
    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createDeck(){
        //Generate Cards
        for (Suit cardSuit: Suit.values()){
            for (Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    public void shuffleCards(){
       ArrayList<Card> tempDeck = new ArrayList<Card>();
       //use Random
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for (int i = 0; i<originalSize;i++){
            //Generate random index
            randomCardIndex = random.nextInt((this.cards.size()-1 - 0)+ 1)+0;
            tempDeck.add(this.cards.get(randomCardIndex));

            //remove from original desc
            this.cards.remove(randomCardIndex);
        }
        this.cards = tempDeck;
    }

    public void removeCard(int i){
        this.cards.remove(i);
    }
    public Card getCard(int i){
        return this.cards.get(i);
    }
    //return deck size
    public int deckSize(){
        return this.cards.size();
    }
    //Return total value of cards in deck
    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;

        for (Card card : this.cards){
            switch (card.getValue()){
                case TWO: totalValue +=2;
                break;
                case THREE: totalValue +=3;
                break;
                case FOUR: totalValue +=4;
                break;
                case FIVE: totalValue +=5;
                break;
                case SIX: totalValue +=6;
                break;
                case SEVEN: totalValue +=7;
                break;
                case EIGHT: totalValue +=8;
                break;
                case NINE: totalValue +=9;
                break;
                case TEN: totalValue +=10;
                break;
                case KING: totalValue +=10;
                break;
                case JACK: totalValue +=10;
                break;
                case QUEEN: totalValue +=10;
                break;
                case ACE: totalValue +=1;
            }
        }
        for (int i = 0; i <aces;i++){
            if (totalValue >10){
                totalValue =+1;
            }
            else {
                totalValue =+11;
            }
        }
        return totalValue;
    }

   //Draw from the deck
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    //card list
    public String toString(){
        String cardList = "";
        for (Card card : this.cards){
            cardList +="\n" + card.toString();
        }
        return cardList;
    }
}
