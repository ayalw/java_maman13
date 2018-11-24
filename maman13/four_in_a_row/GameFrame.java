package maman13.four_in_a_row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    GameEngine engine = new GameEngine();
    FourInARowBoardPanel panel = new FourInARowBoardPanel(engine);
    JButton clearButton = new JButton("Clear");
    JLabel label = new JLabel("Blue Player's Turn");

    public GameFrame() {
        super("4-In-a-Row");
        add(panel);
        repaintLabel();
        label.setVisible(true);
        add(label, BorderLayout.PAGE_START);
        add(clearButton, BorderLayout.PAGE_END);
        setSize(Constants.WINDOW_WIDTH_PIXELS,Constants.WINDOW_HEIGHT_PIXELS);
        setVisible(true);
        setResizable(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = Utils.getRowFromYPosition(e.getY());
                int col = Utils.getColFromXPosition(e.getX());
                engine.playTurn(row, col);
                panel.repaint();
                repaintLabel();
            }
        });
    }

    private void repaintLabel() {
        if (engine.isBluePlayerTurn()) {
            label.setText("Blue Player's Turn");
            label.setForeground(Color.BLUE);
        }
        else {
            label.setText("Red Player's Turn");
            label.setForeground(Color.RED);
        }
        label.repaint();
    }

}
