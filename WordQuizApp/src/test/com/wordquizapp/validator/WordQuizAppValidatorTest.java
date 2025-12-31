package com.wordquizapp.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * JUnit test class for WordValidator
 */
public class WordQuizAppValidatorTest {
    // test 
    /**
    * positive
    */
    @Test
    void testValudateValidInput() {
        //test data setup
        String input = "Hello";

        //Act
        WordQuizAppValidator.ValidationResult result =  WordQuizAppValidator.validate(input);

        //assert
        assertTrue(result.isValid(), "Valid input should return true");
        assertEquals("hello", result.getCleanAnswer(), "The result shoudk be converted to lowercase");
    }

    /**
    * negative: input null
    */
    @Test
    void testValidateNullinput() {
        String input = null; // null
        WordQuizAppValidator.ValidationResult result = WordQuizAppValidator.validate(input);

        //assert
        assertFalse(result.isValid(), "input null shoukd return false");
        assertEquals("Please enter an answer.", result.getErrorMessage(), "The appropriate error message should be set.");
    }
    
    /**
    * negative: input blank
    */
    @Test
    void testValidateEmptyOrSpace() {
        String input = "   "; // only spaces
        WordQuizAppValidator.ValidationResult result = WordQuizAppValidator.validate(input);

        //assert
        assertFalse(result.isValid(), "input with only spaces shoukd return false");
        assertEquals("Please enter an answer.", result.getErrorMessage(), "The appropriate error message should be set.");
    }

    /**
    * negative: input non-alphabetic charactor
    */
    @Test
    void testValidateNonAlphabetic() {
        String input = "word123"; // input number
        WordQuizAppValidator.ValidationResult result = WordQuizAppValidator.validate(input);

        //assert
        assertFalse(result.isValid(), "Input containing non-lphabetic charactors should return false");
        assertEquals("Please use only alphabetic characters.", result.getErrorMessage(), "The appropriate error message should be set.");
    }

    @Test
    void testValidateTooLong() {
        String input = "a".repeat(51); // input number
        WordQuizAppValidator.ValidationResult result = WordQuizAppValidator.validate(input);

        //assert
        assertFalse(result.isValid(), "Input 51 charactors should return false");
        assertEquals("The answer must be 50 characters or less.", result.getErrorMessage(), "The appropriate error message should be set.");
    }

/**
 * Test for isCorrect, Case-insensitive
 */
    /**
    * positive: case insensitive;
    */
    @Test
    void testisCorrectCaseInsensitiveMatch() {
        String user = "apple";
        String correct = "Apple";

        //assert
        assertTrue(WordQuizAppValidator.isCorrect(user, correct), "Should match regardless of case");
    }

    /**
    * negative test for mismatch;
    */
    @Test
    void testisCorrectMismatch() {
        String user = "apple";
        String correct = "strawberry";

        //assert
        assertFalse(WordQuizAppValidator.isCorrect(user, correct), "Should return false if the word does not match");
    }   
}
