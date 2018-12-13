package maman13.trivia;

public class TriviaGameEngine {

    private QuestionRepository m_questionRepository;

    public TriviaGameEngine(String inputFileName) {
        m_questionRepository = new QuestionRepository(inputFileName);
    }

    public Question getNextQuestion() {
        return null; //TODO
    }
}
