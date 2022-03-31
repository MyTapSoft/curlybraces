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
public class StudyProgress {
    private UUID studyProgressId;
    private double totalRate;
    private List<LessonProgress> progresses;
}
