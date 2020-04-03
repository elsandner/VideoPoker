package VideoPoker;

import javax.swing.*;

public class VP_JacksOrBetter {
    public static void main(String[] args) {

        JFrame jf = new JFrame("Video Poker: Scoring: Jacks or Better");
        jf.setSize(800, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(new GUI(true));

        jf.setVisible(true);


    }
}
