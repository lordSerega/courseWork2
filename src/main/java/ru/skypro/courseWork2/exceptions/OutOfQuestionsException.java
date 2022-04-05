package ru.skypro.courseWork2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OutOfQuestionsException extends RuntimeException {
    public OutOfQuestionsException(String message) {
        super(message);
    }
}
