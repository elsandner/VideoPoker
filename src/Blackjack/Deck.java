package Blackjack;

import java.util.ArrayList;

public class Deck {
    private static final int NUM_CARDS_IN_DECK = 52;

    private ArrayList<Card> cards = new ArrayList<>( );

    public Deck( )
    {
        for( int i = 0; i < NUM_CARDS_IN_DECK; i++ )
        {
            cards.add( new Card( i ) );
        }
    }

    public Card drawCard( )
    {
        // Remove the Card from cards and return it
        return cards.remove( 0 );
    }

    public static int getNumCardsInDeck() {
        return NUM_CARDS_IN_DECK;
    }
}
