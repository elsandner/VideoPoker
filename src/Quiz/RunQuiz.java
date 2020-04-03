package Quiz;

import javax.swing.*;

public class RunQuiz {
    public static void main(String[] args) {
        JFrame jf = new JFrame("");
        jf.setSize(200, 200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(new Quiz());
        jf.setVisible(true);
    }
}
