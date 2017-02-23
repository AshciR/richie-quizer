package com.richard.trivia.model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * Unit test for the TriviaQuestionArray accessor.
 */
public class TriviaQuestionArrayAccessorTest {

    @Test
    public void allQuestionsWereLoadedIntoDatabase() {
        long numberOfQuestions = TriviaQuestionArrayAccessor.getDatabase()
                                                            .getQuestionListSize();

        assertEquals(numberOfQuestions, 5);
    }

    @Test
    public void databaseInstancesAreDifferent() {
        TriviaQuestionArrayAccessor dataA = TriviaQuestionArrayAccessor.getDatabase();
        TriviaQuestionArrayAccessor dataB = TriviaQuestionArrayAccessor.getDatabase();

        assertNotEquals(dataA, dataB);
    }

    @Test
    public void ableToGetQuestionsByIndex(){
        long actual = TriviaQuestionArrayAccessor.getDatabase()
                                                 .getQuestionByIndex(0)
                                                 .map(TriviaQuestion::getId)
                                                 .orElseThrow(IndexOutOfBoundsException::new);

        assertEquals(actual, 100);
    }

    @DataProvider()
    private static Object[][] invalidIndices() {
        return new Object[][] {{-1}, {Long.MAX_VALUE}};
    }
    @Test(dataProvider = "invalidIndices",expectedExceptions = IndexOutOfBoundsException.class)
    public void unableToGetQuestionsWithOutOfBoundIndices(long invalidIndex){
        long actual = TriviaQuestionArrayAccessor.getDatabase()
                                                 .getQuestionByIndex(invalidIndex)
                                                 .map(TriviaQuestion::getId)
                                                 .orElseThrow(IndexOutOfBoundsException::new);

    }

    @Test
    public void ableToGetQuestionsById(){
        Optional<Long> actual = TriviaQuestionArrayAccessor.getDatabase()
                                                           .getQuestionById(100)
                                                           .map(TriviaQuestion::getId);

        assertEquals(actual.get().longValue(), 100L);
    }

    @DataProvider()
    private static Object[][] invalidIds() {
        return new Object[][] {{-1}, {Long.MAX_VALUE}};
    }
    @Test(dataProvider = "invalidIds")
    public void unableToGetQuestionsWithNonexistentIds(long invalidId){
        Optional<TriviaQuestion> actual = TriviaQuestionArrayAccessor.getDatabase()
                                                                     .getQuestionById(invalidId);

        assertEquals(actual, Optional.empty());
    }

    @Test
    public void getQuestionsBySpecifiedList(){
        List<TriviaQuestion> questionList = TriviaQuestionArrayAccessor.getDatabase()
                                                                       .getSpecifiedQuestionsList(100, 200, 300);

        List<Long> actual = questionList.stream()
                                        .map(TriviaQuestion::getId)
                                        .collect(Collectors.toList());

        List<Long> expected = Arrays.asList(100L, 200L, 300L);
        assertTrue(actual.containsAll(expected));

    }

    @Test
    public void getQuestionsBySpecifiedListWithInvalidIds(){
        List<TriviaQuestion> questionList = TriviaQuestionArrayAccessor.getDatabase()
                                                                       .getSpecifiedQuestionsList(100, 222, 333, 400);

        List<Long> actual = questionList.stream()
                                        .map(TriviaQuestion::getId)
                                        .collect(Collectors.toList());

        List<Long> expected = Arrays.asList(100L, 400L);
        assertTrue(actual.containsAll(expected));

    }

    @Test
    public void getRandomQuestion(){
        TriviaQuestionArrayAccessor questionDB = TriviaQuestionArrayAccessor.getDatabase();
        TriviaQuestion randomQuestion = questionDB.getRandomQuestion();
        Optional<TriviaQuestion> expected = questionDB.getQuestionById(randomQuestion.getId());

        assertEquals(randomQuestion, expected.get());
    }

    @Test
    public void getQuestionSublistWithValidPartitions(){
        TriviaQuestionArrayAccessor questionDB = TriviaQuestionArrayAccessor.getDatabase();
        List<TriviaQuestion> subList = questionDB.getQuestionList(2);

        assertEquals(subList.size(), 3);
        assertEquals(subList.get(0), questionDB.getQuestionByIndex(2).get());
    }

    @Test(dataProvider = "invalidIndices")
    public void getQuestionSublistWithInvalidOffsets(long index){
        List<TriviaQuestion> list = TriviaQuestionArrayAccessor.getDatabase()
                                                               .getQuestionList(index);

        assertEquals(list, Collections.EMPTY_LIST);

    }

}
