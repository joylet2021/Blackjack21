package com.example.Blackjack21;

import com.example.Blackjack21.services.Deck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Blackjack21Application {

	public static void main(String[] args) {
		SpringApplication.run(Blackjack21Application.class, args);

		Deck playDeck = new Deck();
		playDeck.createDeck();
		playDeck.shuffleCards();

		//create a deck  for the players
		Deck billyDeck = new Deck();
		Deck lemmyDeck = new Deck();
		Deck andrewDeck = new Deck();
		Deck carlaDeck = new Deck();
		Deck dealerDeck = new Deck();

		//player gets cards

		//player1 Billy gets five cards
		billyDeck.draw(playDeck);
		billyDeck.draw(playDeck);
		billyDeck.draw(playDeck);
		billyDeck.draw(playDeck);
		billyDeck.draw(playDeck);

		//Lemmy gets three cards
		lemmyDeck.draw(playDeck);
		lemmyDeck.draw(playDeck);
		lemmyDeck.draw(playDeck);

		//Andrew gets three cards
		andrewDeck.draw(playDeck);
		andrewDeck.draw(playDeck);
		andrewDeck.draw(playDeck);

		// Carla gets three cards
		carlaDeck.draw(playDeck);
		carlaDeck.draw(playDeck);
		carlaDeck.draw(playDeck);

		//dealer gets 2 cards
		dealerDeck.draw(playDeck);
		dealerDeck.draw(playDeck);

		int[] cardsValue = {billyDeck.cardsValue(),lemmyDeck.cardsValue(),andrewDeck.cardsValue(),carlaDeck.cardsValue()};
		String[] playersName = {"Billy","Lemmy","Andrew","Carla"};
		String[] cardsSuit = {billyDeck.toString(),lemmyDeck.toString(),andrewDeck.toString(),carlaDeck.toString()};
        int[] deckSize= {billyDeck.deckSize(),lemmyDeck.deckSize(),andrewDeck.deckSize(),carlaDeck.deckSize()};

		System.out.println("Welcome to Blackjack!");
		System.out.println("---Dealer---");
		System.out.println(dealerDeck.toString());
		System.out.println("Dealer hand valued at:" + dealerDeck.cardsValue() + '\n');

		for (int i = 0; i < cardsValue.length ; i++) {

			if (cardsValue[i] >= dealerDeck.cardsValue() && (cardsValue[i] <= 21)) {

				System.out.println("---"+playersName[i]+"---");
				System.out.println(cardsSuit[i]);
				System.out.println(playersName[i] + " hand valued at:" + cardsValue[i]);
				System.out.println("beats dealer");

			}
			else if(deckSize[i] ==5 && cardsValue[i]<=21){
				System.out.println("---"+playersName[i]+"---");
				System.out.println(cardsSuit[i]);
				System.out.println(playersName[i] + " hand valued at:" + cardsValue[i]);
				System.out.println("beats dealer");
			}
			else
			{
				System.out.println("---"+playersName[i]+"---");
				System.out.println(cardsSuit[i]);
				System.out.println(playersName[i] + " hand valued at:" + cardsValue[i]);
				System.out.println("Loses");
			}
		}
	}

}

