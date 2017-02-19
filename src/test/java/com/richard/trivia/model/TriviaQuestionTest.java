package com.richard.trivia.model;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for the TriviaQuestion data model.
 */
public class TriviaQuestionTest {

    @BeforeClass
    private TriviaQuestion buildTestModel(){
        return new TriviaQuestion.Builder()
                .id(1)
                .question("Who/What does Lemmy love the most?")
                .answerA("Drake")
                .answerB("Richie")
                .answerC("Her Family")
                .answerD("Food")
                .hint("Yum Yum")
                .lastUpdated(LocalDate.now())
                .correctAnswer("Food")
                .build();
    }

    @Test
    public void questionHasTheAllTheCorrectFields() {
        TriviaQuestion questionA = buildTestModel();
        TriviaQuestion questionB = buildTestModel();
        assertEquals(questionA, questionB);
    }
}
