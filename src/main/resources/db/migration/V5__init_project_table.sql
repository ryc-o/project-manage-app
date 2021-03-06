CREATE TABLE PROJECTS (
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    DESCRIPTION VARCHAR(100) NOT NULL
);
CREATE TABLE PROJECT_STEPS (
    ID                  INT PRIMARY KEY AUTO_INCREMENT,
    DESCRIPTION         VARCHAR(100) NOT NULL,
    DAYS_TO_DEADLINE    INT NOT NULL,
    PROJECT_ID          INT NOT NULL,
    FOREIGN KEY (PROJECT_ID) REFERENCES PROJECTS (ID)
);
ALTER TABLE TASK_GROUPS
    ADD COLUMN PROJECT_ID INT NULL;
ALTER TABLE TASK_GROUPS
    ADD FOREIGN KEY (PROJECT_ID) REFERENCES PROJECTS (ID);