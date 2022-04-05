package ru.skypro.courseWork2.services;

import org.springframework.stereotype.Service;
import ru.skypro.courseWork2.data.Question;
import ru.skypro.courseWork2.exceptions.OutOfQuestionsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if (amount <= 0 || size < amount) {
            throw new OutOfQuestionsException("Количество вопросов меньше, чем вы указали");
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() != amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;

    }
}
