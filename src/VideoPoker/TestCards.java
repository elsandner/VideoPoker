package VideoPoker;

import javax.swing.*;
import java.awt.*;

public class TestCards extends JPanel  {

    private Deck cardDeck = new Deck();

    public TestCards(){
        setLayout(new BorderLayout());
        JPanel cards=new JPanel();

        for(int i=0;i<52;i++){
            CardPanel cp = new CardPanel();
            cards.add(cp);
        }
        add(cards);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("Video Poker - Bally's All American");
        jf.setSize(650, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new TestCards());
        jf.setVisible(true);
    }


    private class CardPanel extends JPanel {
        private Card card = cardDeck.drawCard( );
        private JLabel cardLabel = new JLabel(card.toString( ) );

        public CardPanel( )
        {
            cardLabel.setFont( new Font( "TimesRoman", Font.PLAIN, 50 ) );
            add( cardLabel );

        }



    }
}
