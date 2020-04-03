package VideoPoker;

import java.util.stream.IntStream;

public class Scoring {

    //ScoringMechanism:
    // true=JacksOrBetter
    // false=BallysAllAmerican
    public static int JacksOrBetter(Card[] c, boolean scoringMechanism){

        int[] suits = new int[5];
        int[] ranks = new int[5];

        for(int i=0; i<5; i++){
            suits[i]=c[i].getSuit();
            ranks[i]=c[i].getRank();
        }

        if(suits[0]==suits[1]&&
                suits[0]==suits[2]&&
                suits[0]==suits[3]&&
                suits[0]==suits[4]){

            //Royal Flash: A, K, Q, J, 10, of the same suit.
            if(IntStream.of(ranks).anyMatch(x -> x == 0)&&          //Ace
                    IntStream.of(ranks).anyMatch(x -> x == 12)&&     //King
                    IntStream.of(ranks).anyMatch(x -> x == 11)&&     //Queen
                    IntStream.of(ranks).anyMatch(x -> x == 10)&&     //Jack
                    IntStream.of(ranks).anyMatch(x -> x == 9)){     //10
                return 800;
            }

            //Streight Flash: Sequence of 5 cards with the same suit
            for(int i=1;i<8;i++){//rank 01234 bis rank 7,8,9,10,11
                final int j=i;
                if(IntStream.of(ranks).anyMatch(x -> x == j)&&
                        IntStream.of(ranks).anyMatch(x -> x == j+1)&&
                        IntStream.of(ranks).anyMatch(x -> x == j+2)&&
                        IntStream.of(ranks).anyMatch(x -> x == j+3)&&
                        IntStream.of(ranks).anyMatch(x -> x == j+4)){
                    return 50;
                }
            }

            //Flush: 5 cards all of the same suit
            if(scoringMechanism)
                return 6;
            else
                return 8;
        }

        //four of a kind: 4 card of the same rank
        for(int i=0; i<12; i++){
            int counter=0;
            for(int j: ranks){
                if(j==i)
                    counter++;
            }
            if(counter==4)
                return 25;
        }

        //Full House: three cards of one rank and two cards of an other rank
        for(int i=0; i<12; i++){
            int counter=0;
            for(int j: ranks){
                if(j==i)
                    counter++;

                if(counter==3){
                    for(int k=0; k<12; k++){
                        if(k!=j){
                            counter++;
                        }
                        if(counter==5)
                            if(scoringMechanism)
                                return 9;
                            else
                                return 8;
                    }
                }
            }
        }

        //Straight: contains 5 cards of sequential rank, suit doesn't matter
        for(int i=1;i<8;i++){
            final int j=i;
            if(IntStream.of(ranks).anyMatch(x -> x == j)&&
                    IntStream.of(ranks).anyMatch(x -> x == j+1)&&
                    IntStream.of(ranks).anyMatch(x -> x == j+2)&&
                    IntStream.of(ranks).anyMatch(x -> x == j+3)&&
                    IntStream.of(ranks).anyMatch(x -> x == j+4)){
                if(scoringMechanism)
                    return 4;
                else
                    return 8;
            }
        }

        //Three of a kind: contains three cards of the same rank
        for(int i=0; i<12; i++){
            int counter=0;
            for(int j: ranks){
                if(j==i)
                    counter++;

            }
            if(counter==3)
                return 3;
        }

        //two pair: contains two cards of one rank, two cards of another rank
        for(int i=0; i<12; i++){
            int counter=0;
            for(int j: ranks){
                if(j==i)
                    counter++;
                if(counter==2){
                    for(int k=0; k<12; k++){
                        if(k!=i){
                            for(int l: ranks){
                                if(l==k)
                                    counter++;
                                if(counter==2)
                                    if(scoringMechanism)
                                        return 2;
                                    else
                                        return 1;
                            }
                        }
                    }
                }
            }
        }

        //jacks or better: if at least one card is Jack, Queen, Kind or Ace
        for(int i: ranks){
            if(i==0||i>9) {
                return 1;
            }
        }
        return 0;
    }
}
