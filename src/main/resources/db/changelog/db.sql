create table if not exists "users"
(
    user_id           uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    full_name         varchar(64),
    email             varchar(64),
    password          varchar(64),
    registration_date timestamp        NOT NULL DEFAULT (now()),
    level             integer                   DEFAULT 0
);

create table if not exists "topic"
(
    topic_id    uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    difficult   integer          NOT NULL,
    description json
);

create table if not exists "lesson"
(
    lesson_id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    topic_id  uuid             NOT NULL,

    FOREIGN KEY (topic_id) REFERENCES topic (topic_id) ON DELETE CASCADE
);

create table if not exists "quiz"
(
    quiz_id               uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    lesson_id             uuid UNIQUE      NOT NULL,
    questions_and_answers json,

    FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE
);

create table if not exists "theory"
(
    theory_id   uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    lesson_id   uuid UNIQUE      NOT NULL,
    information json,

    FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE
);

create table if not exists "coding"
(
    coding_id       uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    lesson_id       uuid             NOT NULL,
    title           varchar(64),
    description     json,
    preset          json,
    user_solution   json,
    system_solution json,
    dynamic_input   json,
    static_input    json,

    FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE
);

create table if not exists "study_progress"
(
    study_progress_id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    user_id           uuid             NOT NULL,
    total_rate        double precision,

    FOREIGN KEY (user_id) REFERENCES "users" (user_id) ON DELETE CASCADE
);

create table if not exists "lesson_progress"
(
    lesson_progress_id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    lesson_id          uuid             NOT NULL,
    study_progress_id  uuid             NOT NULL,
    lessonScore        double precision          DEFAULT 0,

    FOREIGN KEY (lesson_id) REFERENCES lesson (lesson_id) ON DELETE CASCADE,
    FOREIGN KEY (study_progress_id) REFERENCES "study_progress" (study_progress_id) ON DELETE CASCADE
);

create table if not exists "quiz_progress"
(
    quiz_progress_id      uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    quiz_id               uuid,
    lesson_progress_id    uuid UNIQUE      NOT NULL,
    completed             bool             NOT NULL DEFAULT false,
    success_rate          int                       DEFAULT 0,
    repeat_count          int                       DEFAULT 0,
    required_repeat_count int                       DEFAULT 0,
    last_repeat_date      date,
    required_repeat_date  date,

    FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id) ON DELETE CASCADE,
    FOREIGN KEY (lesson_progress_id) REFERENCES lesson_progress (lesson_progress_id) ON DELETE CASCADE,
    CONSTRAINT success_rate_constraint CHECK (success_rate >= 0 AND success_rate <= 100)
);

create table if not exists "coding_progress"
(
    coding_progress_id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    lesson_progress_id uuid             NOT NULL,
    completed          bool             NOT NULL DEFAULT false,
    coding_id          uuid UNIQUE      NOT NULL,
    FOREIGN KEY (lesson_progress_id) REFERENCES lesson_progress (lesson_progress_id) ON DELETE CASCADE,
    FOREIGN KEY (coding_id) REFERENCES coding (coding_id) ON DELETE CASCADE
);

create table if not exists "theory_progress"
(
    theory_progress_id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    lesson_progress_id uuid UNIQUE      NOT NULL,
    theory_id          uuid,
    completed          bool             NOT NULL DEFAULT false,

    FOREIGN KEY (lesson_progress_id) REFERENCES lesson_progress (lesson_progress_id) ON DELETE CASCADE,
    FOREIGN KEY (theory_id) REFERENCES theory (theory_id) ON DELETE CASCADE
);



