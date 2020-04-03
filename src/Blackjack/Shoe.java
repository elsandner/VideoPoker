package Blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Shoe {

    private ArrayList<Card> shoe = new ArrayList<>( );
    private int numDecks;

    public Shoe(int numDecks ) { //Constructor
        this.numDecks=numDecks;

        for( int i = 0; i < numDecks; i++ )
        {
            addDeck( );
        }
        shuffle();
    }

    private void addDeck( )   //Helper Method
    {
        Deck d = new Deck( );
        for(int i=0; i<Deck.getNumCardsInDeck();i++)
        {
            shoe.add(d.drawCard());
        }
    }

    public void shuffle(){
        Collections.shuffle(shoe);
    }

    public Card drawCard(){

        if(shoe.isEmpty()){
            return null;
        }

        return shoe.remove(0);
    }

    public void reshuffle(){
        shoe.removeAll(shoe);

        for( int i = 0; i < numDecks; i++ )
        {
            addDeck( );
        }
        shuffle();
    }

    public int getNumDecks(){return numDecks;}

    public ArrayList<Card> getShoe(){
        return shoe;
    }
}
