package com.richard.trivia.model;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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

}
