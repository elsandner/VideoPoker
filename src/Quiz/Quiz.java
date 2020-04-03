package Quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JPanel implements ActionListener {
    private JLabel pressCountL = new JLabel("Press Count: 0");
    private int pressCount =0;

    public Quiz(){
        setLayout(new BorderLayout());
        add(pressCountL);

        JButton jb = new JButton("Update Display");
        jb.addActionListener(this);
        add(jb,BorderLayout.SOUTH);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        pressCount++;
        pressCountL.setText("Press Count: "+pressCount);
    }
}
