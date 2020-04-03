package Blackjack;

public class Card {
    private final int suit;
    private final int rank;

    public Card( int val )
    {
        suit = val / 13;
        rank = val % 13;
    }

    public Card( int st, int rnk )
    {
        suit = st;
        rank = rnk;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}
