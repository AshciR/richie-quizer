package com.richard.trivia.model;

import java.time.LocalDate;

/**
 * Data model used to represent a Trivia Question.
 * Created by Richie on 2/18/17.
 */
public final class TriviaQuestion {

    private final long id;
    private final String question;
    private final String answerA;
    private final String answerB;
    private final String answerC;
    private final String answerD;
    private final String correctAnswer;
    private final String hint;
    private final LocalDate lastUpdated;

    public TriviaQuestion(long id, String question, String answerA,
                          String answerB, String answerC, String answerD,
                          String correctAnswer, String hint, LocalDate lastUpdated) {
        this.id = id;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.lastUpdated = lastUpdated;
    }

    public long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getHint() {
        return hint;
    }

    public LocalDate getLastUpdated() {
        return lastUpdated;
    }
}
