package maman13.trivia;

import javax.swing.*;
import java.awt.*;

public class TriviaFrame extends JFrame {

    public TriviaFrame() {
        super("Trivia");
        JPanel questionPanel = new JPanel();
        JTextArea questionText = new JTextArea("Which animal is the biggest?");
        questionPanel.add(questionText);
        add(questionPanel, BorderLayout.NORTH);
        JPanel answersPanel = new JPanel();//
        answersPanel.setLayout(new GridLayout(5,1));
        JRadioButton optionA = new JRadioButton("Elephant2");
        JRadioButton optionB = new JRadioButton("Whale");
        JRadioButton optionC = new JRadioButton("Horse");
        JRadioButton optionD = new JRadioButton("Cow");
        JButton selectButton = new JButton("Choose Answer and Proceed to Next Question");
        ButtonGroup group = new ButtonGroup();
        group.add(optionA);
        group.add(optionB);
        group.add(optionC);
        group.add(optionD);
        answersPanel.add(optionA);
        answersPanel.add(optionB);
        answersPanel.add(optionC);
        answersPanel.add(optionD);
        answersPanel.add(selectButton);
        add(answersPanel, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout());
        JButton startNewGameButton = new JButton("Start New Game");
        buttonsPanel.add(startNewGameButton);
        add(buttonsPanel, BorderLayout.SOUTH);
        setSize(Constants.WINDOW_WIDTH_PIXELS,Constants.WINDOW_HEIGHT_PIXELS);
        setVisible(true);
        setResizable(false);
    }
}
