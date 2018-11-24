package maman13.four_in_a_row;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    FourInARowBoardPanel panel = new FourInARowBoardPanel();
    JButton clearButton = new JButton("Clear");

    public GameFrame() {
        super("4-In-a-Row");
        add(panel);
        add(clearButton, BorderLayout.SOUTH);
        setSize(panel.getSize());
        setVisible(true);
    }

}
