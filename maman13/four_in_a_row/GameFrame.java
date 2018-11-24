package maman13.four_in_a_row;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    FourInARowBoardPanel panel = new FourInARowBoardPanel();
    JButton clearButton = new JButton("Clear");

    public GameFrame() {
        super("4-In-a-Row");
        add(panel);
        add(clearButton, BorderLayout.PAGE_END);
        setSize(Constants.WINDOW_WIDTH_PIXELS,Constants.WINDOW_HEIGHT_PIXELS);
        //setSize(panel.getSize().width, panel.getSize().height + clearButton.getSize().height);
        setVisible(true);
        setResizable(false);
    }

}
