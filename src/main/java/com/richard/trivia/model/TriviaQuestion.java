package com.richard.trivia.model;

import static com.google.common.base.Preconditions.checkState;

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
            checkState(val < 0, "the id has to be a positive number.");
            id = val;
            return this;
        }

        public Builder question(String val) {
            checkState("".equals(val) || val.isEmpty(), "question needs to have a value.");
            question = val;
            return this;
        }

        public Builder answerA(String val) {
            checkState("".equals(val) || val.isEmpty(), "answerA needs to have a value.");
            answerA = val;
            return this;
        }

        public Builder answerB(String val){
            checkState("".equals(val) || val.isEmpty(),"answerB needs to have a value.");
            answerB = val;
            return this;
        }

        public Builder answerC(String val){
            checkState("".equals(val) || val.isEmpty(), "answerC needs to have a value.");
            answerC = val;
            return this;
        }

        public Builder answerD(String val){
            checkState("".equals(val) || val.isEmpty(), "answerD needs to have a value.");
            answerD = val;
            return this;
        }

        public Builder correctAnswer(String val) {
            checkState("".equals(val) || val.isEmpty(), "correctAnswer needs to have a value.");
            correctAnswer = val;
            return this;
        }

        public Builder hint(String val) {
            checkState("".equals(val) || val.isEmpty(), "hint needs to have a value.");
            hint = val;
            return this;
        }
        public Builder lastUpdated(LocalDate val) {
            checkState(null == val, "the lastUpdated needs to have a value.");
            lastUpdated = val;
            return this;
        }

        public TriviaQuestion build() {
            checkState((id < 0)
                               || ("".equals(this.question) || this.question.trim().isEmpty())
                               || ("".equals(this.answerA) || this.answerA.trim().isEmpty())
                               || ("".equals(this.answerB) || this.answerB.trim().isEmpty())
                               || ("".equals(this.answerC) || this.answerC.trim().isEmpty())
                               || ("".equals(this.answerD) || this.answerD.trim().isEmpty())
                               || ("".equals(this.correctAnswer) || this.correctAnswer.trim().isEmpty())
                               || ("".equals(this.hint) || this.hint.trim().isEmpty())
                               || (this.lastUpdated == null), "the question is in an incomplete state.");
            return new TriviaQuestion(this);
        }
    }
}
