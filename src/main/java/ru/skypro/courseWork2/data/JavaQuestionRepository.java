package ru.skypro.courseWork2.data;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository("javaRepository")
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        add(new Question("Вопрос по дажава 1?", "1"));
        add(new Question("Вопрос по джава 2", "2"));
        add(new Question("Вопрос по джава 3", "3"));

    }

    @Override
    public boolean add(Question question) {
       return questions.add(question);

    }

    @Override
    public boolean remove(Question question) {
        return questions.remove(question);

    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}