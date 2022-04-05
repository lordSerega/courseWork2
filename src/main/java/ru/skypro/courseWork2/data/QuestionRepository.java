package ru.skypro.courseWork2.data;

import java.util.Collection;

public interface QuestionRepository {

    boolean add(Question question);
    boolean remove(Question question);

    Collection<Question> getAll();
}
