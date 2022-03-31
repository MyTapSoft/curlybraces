package com.curlybraces.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonProgress {//event and triggers
    private UUID lessonProgressId;
    private double lessonScore;
    private List<TheoryProgress> theoryProgresses;
    private List<CodingProgress> codingProgresses;
    private List<QuizProgress> quizProgresses;
}
