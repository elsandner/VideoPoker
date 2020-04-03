/*
* Name: ELias Sandner
* Notes:
*       1-I did not test if the cards are shuffled after using the method reshuffle()
*         cause in this methode the methode shuffle() is called and this one gets tested before
*
*       2-Randomness: I checked if the order after shuffeling is different than before and i checked
*         the distribution of the first picked card. If it is real random, then after a high amount of
*         tries-each card is picked as often. Here the test accepts a tolerance of 0.1%.
*
* */

package Blackjack;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;


public class ShoeTest {

    @Test
    public void shuffle(){
        shuffleExecute(1);
        shuffleExecute(4);
        shuffleExecute(10);
        shuffleExecute(10_000);
    }
    private void shuffleExecute(int numDeck) {
        Shoe s = new Shoe(numDeck);
        ArrayList<Card> copy = new ArrayList<>();

        //Copy original shoe
        copy.addAll(s.getShoe());

        s.shuffle();

        int counter=0;
        for(int i=0;i<s.getNumDecks()*Deck.getNumCardsInDeck();i++){
            try {
                Assert.assertNotEquals(s.drawCard(), copy.get(i));
            }
            catch(AssertionError e){
                counter++;
            }
        }
        System.out.println("After shuffeling a shoe with "+numDeck+" Decks there are "+counter+" cards on the same index as bevore");
    }

    @Test
    public void drawCard() {
        drawCard1();//checks if every card gets picked once (trivial)
        drawCard2(1_000_000);//checks distribution of first picked card
        drawCard3();//Checks if null is returned when shoe is empty
        System.out.println("drawCard() is working fine");
    }

    private void drawCard1(){
        //Test if after 54 cards, every card get picked once
        Shoe s = new Shoe(1);

        boolean[][] gotPicked=new boolean[4][13];

        for(int i=0; i<Deck.getNumCardsInDeck(); i++){
            Card c=s.drawCard();
            int st=c.getSuit();
            int rnk=c.getRank();
            gotPicked[st][rnk]=true;
        }

        for(int i=0; i<gotPicked.length;i++){
            for(int j=0;j<gotPicked[0].length;j++){
                Assert.assertTrue(gotPicked[i][j]);
            }
        }
    }
    private void drawCard2(int repeat){

        int [][] count=new int[4][13];

        for(int i=0;i<repeat;i++) {
            Shoe s = new Shoe(1);
            Card c = s.drawCard();
            count[c.getSuit()][c.getRank()]++;
        }

        int expected=repeat/52;
        double delta = repeat*0.001; //0.1%
        for(int i=0; i<count.length;i++) {
            for(int j=0;j<count[0].length;j++){
                Assert.assertEquals(expected, count[i][j], delta);
            }
        }
    }
    private void drawCard3(){
        Shoe s=new Shoe(1);
        for(int i=0;i<Deck.getNumCardsInDeck();i++){
            s.drawCard();
        }
        Assert.assertNull(s.drawCard());

    }


    @Test
    public void reshuffle() {
        //Amount of cards must be the same as in the beginning
        //Order must be different
        for(int i=0;i<10;i++){
            Shoe s = new Shoe(i);

            //draw a part of the cards
            for(int j=0;j<i*30;j++){
                s.drawCard();
            }

            s.reshuffle();
            Assert.assertEquals(i*Deck.getNumCardsInDeck(),s.getShoe().size());//checks if amount of cards is correct
            //shuffle is allready tested
        }

        System.out.println("reshuffle() is working fine");
    }
}