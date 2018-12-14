package maman13.trivia;

public class Question {

    private String m_questionText;
    private String m_correctAnswer;
    private String m_incorrectAnswerA;
    private String m_incorrectAnswerB;
    private String m_incorrectAnswerC;

    public Question(String questionText,
                    String correctAnswer,
                    String incorrectAnswerA,
                    String incorrectAnswerB,
                    String incorrectAnswerC) {
        m_questionText = questionText;
        m_correctAnswer = correctAnswer;
        m_incorrectAnswerA = incorrectAnswerA;
        m_incorrectAnswerB = incorrectAnswerB;
        m_incorrectAnswerC = incorrectAnswerC;
    }

    public String getQuestionText() {
        return m_questionText;
    }

    public String get_correctAnswer() {
        return m_correctAnswer;
    }

    public String getIncorrectAnswerA() {
        return m_incorrectAnswerA;
    }

    public String getIncorrectAnswerB() {
        return m_incorrectAnswerB;
    }

    public String getIncorrectAnswerC() {
        return m_incorrectAnswerC;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Text: " + m_questionText + " | ");
        sb.append("IncorrectA: " + m_incorrectAnswerA + " | ");
        sb.append("IncorrectA: " + m_incorrectAnswerB + " | ");
        sb.append("IncorrectA: " + m_incorrectAnswerC + " | ");
        return sb.toString();
    }
}
