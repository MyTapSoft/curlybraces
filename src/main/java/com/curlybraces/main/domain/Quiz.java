package com.curlybraces.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private UUID quizId;
    private Lesson lesson;
    private String questionsAndAnswers;
}
