package maman13.trivia;

public class TriviaGameEngine {

    private QuestionRepository m_questionRepository;

    public TriviaGameEngine(String inputFileName) {
        m_questionRepository = new QuestionRepository(inputFileName);
    }

    public Question getNextQuestion() {
        if (!m_questionRepository.hasUnusedQuestions()) {
            return null;
        }
        return  m_questionRepository.getRandomQuestion();
    }
}
