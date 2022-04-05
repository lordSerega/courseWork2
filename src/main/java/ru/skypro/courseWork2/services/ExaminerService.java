package ru.skypro.courseWork2.services;

import ru.skypro.courseWork2.data.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
