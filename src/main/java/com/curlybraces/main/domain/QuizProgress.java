package com.curlybraces.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizProgress {
    private UUID quizProgressId;
    private UUID quizId;
    private ProgressStatus status;
    private double quizScore;
    private int repeatCount;
    private int requiredRepeatCount;
    private LocalDateTime lastRepeatDate;
    private LocalDateTime requiredRepeatDate;
}
