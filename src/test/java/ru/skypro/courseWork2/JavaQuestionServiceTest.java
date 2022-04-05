package ru.skypro.courseWork2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.courseWork2.data.JavaQuestionRepository;
import ru.skypro.courseWork2.data.Question;
import ru.skypro.courseWork2.services.JavaQuestionService;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository repository;
    @InjectMocks
    private JavaQuestionService out;

    @Test
    public void addTest() {
        Question question = new Question("question", "answer");
        when(repository.add(question)).thenReturn(true, false);
        assertTrue(out.add(question));
        assertFalse(out.add(question));
    }

    @Test
    public void removeTest() {
        Question question = new Question("question", "answer");
        when(repository.remove(question)).thenReturn(true, false);
        assertTrue(out.remove(question));
        assertFalse(out.remove(question));
    }

    @Test
    public void getAllTest() {
        Set<Question> questions = Set.of(
                new Question("question", "answer"),
                new Question("question1", "answer1")
        );
        when(repository.getAll()).thenReturn(questions);
        assertEquals(out.getAll().size(), questions.size());
        assertTrue(out.getAll().containsAll(questions));
    }
}
