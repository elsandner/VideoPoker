package VideoPoker;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUI extends JPanel implements ActionListener {

    private Deck cardDeck = new Deck();
    private ArrayList<CardPanel> players = new ArrayList<>();

    private JLabel scoreLabel = new JLabel("Score: 0");
    private int totalScore=0;
    private boolean scoringMechanism;

    public GUI(boolean scoringMechanism){

        this.scoringMechanism=scoringMechanism;
        setLayout(new BorderLayout());
        JPanel cards=new JPanel();

        for(int i=0;i<5;i++){
            CardPanel cp = new CardPanel();
            players.add(cp);
            cards.add(cp);
        }
        add(cards);

        JButton DealDraw = new JButton("Deal / Draw");
        DealDraw.addActionListener(this);
        DealDraw.setBackground(Color.white);
        add(DealDraw, BorderLayout.SOUTH);

        add(scoreLabel, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //update Cards
        if(cardDeck.isEmpty()){
            cardDeck.refill();
        }



        for(int i=0;i<5;i++) {
            if (players.get(i).getCardLabel().getBorder() == null)
                players.get(i).updateCardLabel(cardDeck.drawCard());
        }

        Card[] c = new Card[5];
        for(int i=0; i<5; i++){
            c[i]=players.get(i).getCard();
        }

        //updateScore
        totalScore--;
        totalScore=totalScore+Scoring.JacksOrBetter(c,scoringMechanism);
        scoreLabel.setText( "Score: " + totalScore );

    }

    //private inner class for security reason
    private class CardPanel extends JPanel {
        private Card card = cardDeck.drawCard( );
        private JLabel cardLabel = new JLabel(card.toString( ) );

        public CardPanel( )
        {
            cardLabel.setFont( new Font( "TimesRoman", Font.PLAIN, 160 ) );
            add( cardLabel );
            addMouseListener(new CardPanelListener());
        }

        public Card getCard( )
        {
            return card;
        }

        public void updateCardLabel(Card card){
            this.card=card;
            cardLabel.setText(card.toString());

        }
        public JLabel getCardLabel(){
            return cardLabel;
        }

        private class CardPanelListener extends MouseAdapter
        {
            @Override
            public void mouseClicked( MouseEvent e )
            {
                if(cardLabel.getBorder()==null){
                    cardLabel.setBorder(BorderFactory.createLineBorder(Color.blue));
                }
                else {
                    cardLabel.setBorder(null);
                }
            }
        }
    }
}
