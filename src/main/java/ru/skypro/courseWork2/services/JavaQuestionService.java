package ru.skypro.courseWork2.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.skypro.courseWork2.data.JavaQuestionRepository;
import ru.skypro.courseWork2.data.Question;
import ru.skypro.courseWork2.data.QuestionRepository;

import java.util.*;

@Service("javaService")
public class JavaQuestionService implements QuestionService {

    private final QuestionRepository javaQuestionRepository;
    private final Random random = new Random();

    public JavaQuestionService(@Qualifier("javaRepository") QuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public boolean add(String question, String answer) {
        return javaQuestionRepository.add(new Question(question,answer));
    }

    @Override
    public boolean add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public boolean remove(Question question) {
        return javaQuestionRepository.remove(question);
    }


    @Override
    public boolean remove(String question, String answer) {;
        return javaQuestionRepository.remove(new Question(question,answer));
    }

    @Override
    public Collection<Question> getAll() {
        return Set.copyOf(javaQuestionRepository.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        return List.copyOf(javaQuestionRepository.getAll()).get(random.nextInt(javaQuestionRepository.getAll().size()));

    }
    @Override
    public int getSize() {
        return javaQuestionRepository.getAll().size();
    }


}