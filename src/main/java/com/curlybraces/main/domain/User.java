package com.curlybraces.main.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID userId;
    private String fullName;
    private String email;
    private String password;
    private LocalDateTime registrationDate;
    private int level;
    private StudyProgress studyProgress;
}
