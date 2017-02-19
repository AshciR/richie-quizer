package com.richard.trivia.model;

import java.util.List;
import java.util.Optional;

/**
 * Interface which allows implementations to get Trivia Questions
 * from the the question database.
 * Created by Richie on 2/19/17.
 */
public interface TriviaQuestionAccessible {

    /**
     * Gets a trivia question from a known index location,
     * if the index is within bounds.
     *
     * @param index the index position of the question.
     * @return the trivia question if it exists.
     */
    Optional<TriviaQuestion> getQuestionByIndex(long index);

    /**
     * Gets a trivia question based on its id,
     * if the question exists.
     *
     * @param id the id of the trivia question.
     * @return the trivia question if it exists.
     */
    Optional<TriviaQuestion> getQuestionById(long id);

    /**
     * Gets a random trivia question
     * @return a random trivia question.
     */
    Optional<TriviaQuestion> getRandomQuestion();

    /**
     * Returns a sublist of questions from the database
     * starting from a particular location.
     * @param offset the location for which the sublist should start
     * @return the sublist of questions
     */
    List<TriviaQuestion> getQuestionList(long offset);

    /**
     * Gets a list of questions based on their ids.
     * @param id the ids of the questions to be returned.
     * @return the list of the questions whose ids were supplied.
     */
    List<TriviaQuestion> getSpecifiedQuestionsList(long... id);

    /**
     * Gets number of question currently in the database.
     * @return the number of questions in the database.
     */
    long getQuestionListSize();

}
