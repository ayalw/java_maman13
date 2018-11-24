package maman13.four_in_a_row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {
    GameEngine engine = new GameEngine();
    FourInARowBoardPanel panel = new FourInARowBoardPanel(engine);
    JButton clearButton = new JButton("Clear");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");

    JLabel label = new JLabel();
    JPanel buttonsPanel = new JPanel();


    public GameFrame() {
        super("4-In-a-Row");
        add(panel);
        repaintLabel();
        label.setVisible(true);
        add(label, BorderLayout.PAGE_START);
        //add(clearButton, BorderLayout.PAGE_END);
        buttonsPanel.add(btn1);
        buttonsPanel.add(btn2);
        buttonsPanel.add(btn3);
        buttonsPanel.add(btn4);
        buttonsPanel.add(btn5);
        buttonsPanel.add(btn6);
        buttonsPanel.add(btn7);
        buttonsPanel.add(clearButton);



        add(buttonsPanel, BorderLayout.PAGE_END);
        setSize(Constants.WINDOW_WIDTH_PIXELS,Constants.WINDOW_HEIGHT_PIXELS);
        setVisible(true);
        setResizable(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                y-=25; //TODO check why this is needed
                System.out.println("["+x+","+y+"]");
                int clickedRow = Utils.getRowFromYPosition(y);
                int clickedCol = Utils.getColFromXPosition(x);
                handleClickOnColumn(clickedCol);

            }
        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                engine.clear();
                panel.repaint();
                repaintLabel();
            }
        } );
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(0);
            }
        } );
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(1);
            }
        } );
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(2);
            }
        } );
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(3);
            }
        } );
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(4);
            }
        } );
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(5);
            }
        } );
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleClickOnColumn(6);
            }
        } );
    }

    private void handleClickOnColumn(int clickedCol) {
        Position discFallingPosition = engine.getLowestAvailableCellAtColumn(clickedCol);
        engine.playTurn(discFallingPosition.getRow(), discFallingPosition.getCol());
        panel.repaint();
        repaintLabel();
        GameResult result = engine.checkIfGameHasFinished(new Position(discFallingPosition.getRow(), discFallingPosition.getCol()));
        if (result == GameResult.BLUE_HAS_WON) {
            //JOptionPane.showMessageDialog(GameFrame.this, "Blue player has won!!!");
            JOptionPane.showMessageDialog(null, "Blue player has won!!!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            engine.clear();
            panel.repaint();
            repaintLabel();
        }
        if (result == GameResult.RED_HAS_WON) {
            JOptionPane.showMessageDialog(null, "Red player has won!!!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            engine.clear();
            panel.repaint();
            repaintLabel();
        }
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
