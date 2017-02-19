package com.richard.trivia.model;

import java.time.LocalDate;

import static com.google.common.base.Preconditions.checkState;

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

    private TriviaQuestion(Builder builder) {
        this.id = builder.id;
        this.question = builder.question;
        this.answerA = builder.answerA;
        this.answerB = builder.answerB;
        this.answerC = builder.answerC;
        this.answerD = builder.answerD;
        this.correctAnswer = builder.correctAnswer;
        this.hint = builder.hint;
        this.lastUpdated = builder.lastUpdated;
    }

    /**
     * Determines if too questions are equal.
     * In order for questions to equal, are the fields have to be identical.
     * If any field differs, then this method will return false.
     *
     * @param o the object to check, null returns false
     * @return true if this is equal to the other question
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriviaQuestion that = (TriviaQuestion) o;

        if (id != that.id) return false;
        if (!question.equals(that.question)) return false;
        if (!answerA.equals(that.answerA)) return false;
        if (!answerB.equals(that.answerB)) return false;
        if (!answerC.equals(that.answerC)) return false;
        if (!answerD.equals(that.answerD)) return false;
        if (!correctAnswer.equals(that.correctAnswer)) return false;
        if (!hint.equals(that.hint)) return false;
        return lastUpdated.equals(that.lastUpdated);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriviaQuestion{");
        sb.append("id=").append(id);
        sb.append(", question='").append(question).append('\'');
        sb.append(", answerA='").append(answerA).append('\'');
        sb.append(", answerB='").append(answerB).append('\'');
        sb.append(", answerC='").append(answerC).append('\'');
        sb.append(", answerD='").append(answerD).append('\'');
        sb.append(", correctAnswer='").append(correctAnswer).append('\'');
        sb.append(", hint='").append(hint).append('\'');
        sb.append(", lastUpdated=").append(lastUpdated);
        sb.append('}');
        return sb.toString();
    }

    /**
     * The builder class used to create Trivia Questions.
     * Trivia Questions can only be created using this builder.
     * It also requires all fields to be supplied with correct values or
     * it will throw an IllegalState Exception.
     */
    public static class Builder {

        // Required parameters
        private long id;
        private String question;
        private String answerA;
        private String answerB;
        private String answerC;
        private String answerD;
        private String correctAnswer;
        private String hint;
        private LocalDate lastUpdated;

        public Builder id(long val) {
            checkState(val > 0, "the id has to be a positive number.");
            id = val;
            return this;
        }

        public Builder question(String val) {
            checkState(isStringValid(val), "question needs to have a value.");
            question = val;
            return this;
        }

        public Builder answerA(String val) {
            checkState(isStringValid(val), "answerA needs to have a value.");
            answerA = val;
            return this;
        }

        public Builder answerB(String val){
            checkState(isStringValid(val),"answerB needs to have a value.");
            answerB = val;
            return this;
        }

        public Builder answerC(String val){
            checkState(isStringValid(val), "answerC needs to have a value.");
            answerC = val;
            return this;
        }

        public Builder answerD(String val){
            checkState(isStringValid(val), "answerD needs to have a value.");
            answerD = val;
            return this;
        }

        public Builder correctAnswer(String val) {
            checkState(isStringValid(val), "correctAnswer needs to have a value.");
            correctAnswer = val;
            return this;
        }

        public Builder hint(String val) {
            checkState(isStringValid(val), "hint needs to have a value.");
            hint = val;
            return this;
        }
        public Builder lastUpdated(LocalDate val) {
            checkState(null != val, "the lastUpdated needs to have a value.");
            lastUpdated = val;
            return this;
        }

        public TriviaQuestion build() {
            checkState(id > 0, "the id has to be a positive number.");
            checkState(isStringValid(question), "question needs to have a value.");
            checkState(isStringValid(answerA), "answerA needs to have a value.");
            checkState(isStringValid(answerB), "answerB needs to have a value.");
            checkState(isStringValid(answerC), "answerC needs to have a value.");
            checkState(isStringValid(answerD), "answerD needs to have a value.");
            checkState(isStringValid(correctAnswer), "correctAnswer needs to have a value.");
            checkState(isStringValid(hint), "hint needs to have a value.");
            checkState(null != lastUpdated, "the lastUpdated needs to have a value.");
            return new TriviaQuestion(this);
        }

        private boolean isStringValid(String val){
            return !(null == val || "".equals(val) || val.trim().isEmpty());
        }

    }
}
