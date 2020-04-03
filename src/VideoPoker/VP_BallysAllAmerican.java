package VideoPoker;

import javax.swing.*;

public class VP_BallysAllAmerican {
    public static void main(String[] args) {

        JFrame jf = new JFrame("Video Poker - Bally's All American");
        jf.setSize(800, 300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(new GUI(false));
        jf.setVisible(true);


    }
}
