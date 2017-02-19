package com.richard.trivia.model;

import java.util.List;
import java.util.Optional;

/**
 * Interface which allows implementations to get Trivia Questions
 * from the the question database.
 * Created by Richie on 2/19/17.
 */
public interface TriviaQuestionAccessible {

    Optional<TriviaQuestion> getQuestionByIndex(long index);

    Optional<TriviaQuestion> getQuestionById(long id);

    Optional<TriviaQuestion> getRandomQuestion();

    List<TriviaQuestion> getQuestionList(long offset);

    List<TriviaQuestion> getSpecifiedQuestionsList(long... id);

    long getQuestionListSize();

}
