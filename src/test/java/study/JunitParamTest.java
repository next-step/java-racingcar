package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitParamTest {

    static Stream<Arguments> arguments = Stream.of(
            Arguments.of(null, true),
            Arguments.of("", true),
            Arguments.of("  ", true),
            Arguments.of("not blank", false)
    );

    @DisplayName("StringsUnitTest")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input){
        assertTrue(StringsForTest.isBlank(input));
    }

    @DisplayName("StringsUnitTest")
    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input){
        assertTrue(StringsForTest.isBlank(input));
    }

    @DisplayName("StringsUnitTest")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void isBlank_ShouldReturnTrueForAllTypesOfBlankStrings(String input){
        assertTrue(StringsForTest.isBlank(input));
    }

    private static Stream<Arguments> provideStringsForIsBlank(){
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of(" ", true),
                Arguments.of("not blank", false)
        );
    }

    @DisplayName("StringsUnitTest")
    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected){
        assertEquals(expected, StringsForTest.isBlank(input));
    }

    @DisplayName("StringsUnitTest")
    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void toLowerCase_ShouldGenerateExpectedLowerCase(String input, String expected){
        String actValue = input.toLowerCase();
        assertEquals(expected, actValue);
    }

    @DisplayName("EnumTest")
    @ParameterizedTest
    @EnumSource(Month.class)
    void getValueForAMonth_IsAlwaysBetweenOneAndTwelve(Month month){
        int monthNumber = month.getValue();
        assertTrue(monthNumber >= 1 && monthNumber <= 12);
    }

    @DisplayName("EnumTest")
    @ParameterizedTest(name = "{index} {0} is 30 days long")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(Month month){
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    @DisplayName("EnumTest")
    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"}
    , mode = EnumSource.Mode.EXCLUDE)
    void exceptFourMonths_OthersAre31DaysLong(Month month){
        final boolean isALeapYear = false;
        assertEquals(31, month.length(isALeapYear));
    }

    @DisplayName("EnumTest")
    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = EnumSource.Mode.MATCH_ANY)
    void fourMonths_EndingWithBer(Month month){
        EnumSet<Month> months = EnumSet.of(Month.OCTOBER, Month.DECEMBER, Month.NOVEMBER, Month.SEPTEMBER);
        assertTrue(months.contains(month));
    }

    @DisplayName("ValueSource_Ints")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd_ShouldReturnTrue(int number){
        assertTrue(NumbersForTest.isOdd(number));
    }
}
