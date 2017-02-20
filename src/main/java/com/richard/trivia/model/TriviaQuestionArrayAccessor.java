package com.richard.trivia.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The array implementation of the Trivia Question database.
 * Created by Richie on 2/19/17.
 */
public final class TriviaQuestionArrayAccessor implements TriviaQuestionAccessible {

    private final List<TriviaQuestion> questions;

    // Prevents instantiation of the class
    private TriviaQuestionArrayAccessor(){
        this.questions = loadTheDatabase();
    }

    public static TriviaQuestionArrayAccessor getDatabase(){
        return new TriviaQuestionArrayAccessor();
    }

    /**
     * Gets a trivia question from a known index location,
     * if the index is within bounds.
     *
     * @param index the index position of the question.
     * @return the trivia question if it exists.
     */
    @Override
    public Optional<TriviaQuestion> getQuestionByIndex(long index) {

        Optional<TriviaQuestion> question;

        try {
            question = Optional.of(this.questions.get((int) index));
        } catch (IndexOutOfBoundsException e) {
            question = Optional.empty();
        }

        return question;
    }

    /**
     * Gets a trivia question based on its id,
     * if the question exists.
     *
     * @param id the id of the trivia question.
     * @return the trivia question if it exists.
     */
    @Override
    public Optional<TriviaQuestion> getQuestionById(long id) {

        return this.questions.stream()
                             .filter(question -> question.getId() == id)
                             .findAny();

    }

    /**
     * Gets a random trivia question
     *
     * @return a random trivia question.
     */
    @Override
    public TriviaQuestion getRandomQuestion() {
        return null;
    }

    /**
     * Returns a sublist of questions from the database
     * starting from a particular location.
     *
     * @param offset the location for which the sublist should start
     * @return the sublist of questions
     */
    @Override
    public List<TriviaQuestion> getQuestionList(long offset) {
        return null;
    }

    /**
     * Gets a list of questions based on their ids.
     *
     * @param id the ids of the questions to be returned.
     * @return the list of the questions whose ids were supplied.
     */
    @Override
    public List<TriviaQuestion> getSpecifiedQuestionsList(long... id) {
        return null;
    }

    /**
     * Gets number of question currently in the database.
     *
     * @return the number of questions in the database.
     */
    @Override
    public long getQuestionListSize() {
        return this.questions.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriviaQuestionArrayAccessor{");
        sb.append("questions=").append(questions);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Helper method used to load the database instance with trivia questions.
     * @return a list of trivia questions.
     */
    private List<TriviaQuestion> loadTheDatabase() {

        List<TriviaQuestion> questions = new ArrayList<>();

        questions.add(new TriviaQuestion.Builder()
                              .id(100)
                              .question("How many feet are in a mile?")
                              .answerA("5260")
                              .answerB("5270")
                              .answerC("5280")
                              .answerD("5290")
                              .correctAnswer("C")
                              .hint("The altitude of Denver, Colorado")
                              .lastUpdated(LocalDate.now())
                              .build()
                     );

        questions.add(new TriviaQuestion.Builder()
                              .id(200)
                              .question("What was the first toy advertised on television?")
                              .answerA("The Rubix Cube")
                              .answerB("Mr. Potato Head")
                              .answerC("Barbie")
                              .answerD("A hula hoop")
                              .correctAnswer("B")
                              .hint("Use your head on this one")
                              .lastUpdated(LocalDate.now())
                              .build()
                     );

        questions.add(new TriviaQuestion.Builder()
                              .id(300)
                              .question("The martial art of kung fu originated in which country?")
                              .answerA("Viet Nam")
                              .answerB("United States")
                              .answerC("Japan")
                              .answerD("China")
                              .correctAnswer("D")
                              .hint("Name most likely derives from the name of the Qin dynasty")
                              .lastUpdated(LocalDate.now())
                              .build()
                     );

        questions.add(new TriviaQuestion.Builder()
                              .id(400)
                              .question("Which 1979 film included a spaceship called Nostromo?")
                              .answerA("The Emperor Strikes Back")
                              .answerB("Alien")
                              .answerC("The Black Hole")
                              .answerD("Star Trek: The Motion Picture")
                              .correctAnswer("B")
                              .hint("Not from this world")
                              .lastUpdated(LocalDate.now())
                              .build()
                     );

        questions.add(new TriviaQuestion.Builder()
                              .id(500)
                              .question("Which country lies on the border between Spain and France?")
                              .answerA("Andorra")
                              .answerB("Luxemborg")
                              .answerC("England")
                              .answerD("Portugal")
                              .correctAnswer("A")
                              .hint("Go with your first guess")
                              .lastUpdated(LocalDate.now())
                              .build()
                     );

        return questions;
    }

}
