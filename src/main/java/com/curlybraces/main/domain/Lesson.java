package com.curlybraces.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    private UUID lessonId;
    private Topic topic;
    private List<Quiz> quiz;
    private List<Coding> coding;
    private Theory theory;
}
