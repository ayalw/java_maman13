package maman13.trivia;

public class TriviaGameEngine {

    private QuestionRepository m_questionRepository;
    private int m_score;

    public TriviaGameEngine(String inputFileName) {
        m_questionRepository = new QuestionRepository(inputFileName);
        m_score = 0;
    }

    public Question getNextQuestion() {
        if (!m_questionRepository.hasUnusedQuestions()) {
            return null;
        }
        return  m_questionRepository.getRandomQuestion();
    }

    public int checkScore(Question question, String chosenAnswer) {
        if (question == null) return m_score;
        if (chosenAnswer != null && chosenAnswer.equals(question.getCorrectAnswer())) {
            m_score += 10;
        }
        else {
            m_score -=5;
        }
        return m_score;
    }
}
