package VideoPoker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private static final int NUM_CARDS_IN_DECK = 52;

    private ArrayList<Card> cards = new ArrayList<>( );

    public Deck( ) {
        for( int i = 0; i < NUM_CARDS_IN_DECK; i++ )
        {
            cards.add( new Card( i ) );
        }
        Collections.shuffle( cards );
    }

    public Card drawCard( ) {
        return cards.remove( 0 );
    }

    public boolean isEmpty( ) {
        if (cards.size()<5)
            return true;
        else
            return false;
    }

    public void refill(){
        int size=cards.size();
        for( int i = 0; i < NUM_CARDS_IN_DECK; i++ )
        {
            Card c= new Card(i);
            boolean exist=false;
            for(int j=0;j<size;j++) {
                if(cards.get(j).equals(c))
                    exist=true;
            }
            if(!exist)
                cards.add(c);
        }
        Collections.shuffle( cards );
    }

    public void printDeck() {
        for(int i=0;i<NUM_CARDS_IN_DECK;i++){
            System.out.println("#"+i+" Suit: "+cards.get(i).getSuit()+"\tRank: "+cards.get(i).getRank()+"\t\t"+cards.get(i).toString());
        }
    }

}

