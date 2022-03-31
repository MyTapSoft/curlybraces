package com.curlybraces.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodingProgress {
    private UUID codingProgressId;
    private UUID codingId;
    private ProgressStatus status;
}
