package maman13.trivia;

import javax.swing.*;
import java.awt.*;

public class TriviaFrame extends JFrame {

    private JPanel questionPanel;
    private JPanel answersPanel;
    private JTextArea questionText;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private JButton selectButton;
    private ButtonGroup group;
    private JPanel buttonsPanel;
    private JButton startNewGameButton;


    public TriviaFrame() {
        super("Trivia");
        initTriviaFrame();
        TriviaGameEngine engine = new TriviaGameEngine("input.txt");
        Question currentQuestion = engine.getNextQuestion();
        displayQuestion(currentQuestion);
    }

    private void initTriviaFrame() {
        questionPanel = new JPanel();
        questionText = new JTextArea();
        questionPanel.add(questionText);
        add(questionPanel, BorderLayout.NORTH);
        answersPanel = new JPanel();
        answersPanel.setLayout(new GridLayout(5,1));
        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();
        selectButton = new JButton("Choose Answer and Proceed to Next Question");
        group = new ButtonGroup();
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
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout());
        startNewGameButton = new JButton("Start New Game");
        buttonsPanel.add(startNewGameButton);
        add(buttonsPanel, BorderLayout.SOUTH);
        setSize(Constants.WINDOW_WIDTH_PIXELS,Constants.WINDOW_HEIGHT_PIXELS);
        setVisible(true);
        setResizable(false);
    }

    private void displayQuestion(Question question) {
        questionText.setText("what color is the sky?");
        optionA.setText("red");
        optionB.setText("blue");
        optionC.setText("purple");
        optionD.setText("gold");
    }
}
