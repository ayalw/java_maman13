package maman13.trivia;

import java.util.Map;

public class QuestionRepository {

    public QuestionRepository(String inputFile) {
        //TODO load from input file
    }

    private Map<Integer, Question> m_allQuestions;

    private Map<Integer, Boolean> m_questionsUsed;

    public Question getRandomQuestion() {
        return null;//TODO
    }

    public boolean hasUnusedQuestions() {
        return false; //TODO
    }
}
