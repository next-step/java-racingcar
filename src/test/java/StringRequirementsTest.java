import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringRequirementsTest {

    private StringRequirements stringRequirements;

    @BeforeEach
    void setUp(){
        stringRequirements = new StringRequirements();
    }

    @Test
    public void splitIntegersReturnsTwoIntegers(){
        assertThat(stringRequirements.splitIntegers("1,2"))
                .contains(1)
                .contains(2);
    }

    @Test
    public void splitIntegersReturnsTwoIntegersWithExactOrder(){
        String testInput = "1,2";
        assertThat(stringRequirements.splitIntegers(testInput))
                .containsExactly(1,2);
    }

    @Test
    public void splitIntegersReturnsOneInteger(){
        assertThat(stringRequirements.splitIntegers("1,"))
                .contains(1);
    }

    @Test
    public void removeBracketsReturnsStringWithoutBrackets(){
        String testInput = "(1,2)";
        assertThat(stringRequirements.removeBrackets(testInput))
                .contains("1,2");
    }

    @Test
    @DisplayName("범위에 맞지 않는 문자열 인덱스의 값을 구할 경우 에러를 던짐")
    public void getCharAtInvalidIdxThrowsException(){
        String testString = "testing";
        int testNegativeIdx = -1;
        int testPositiveIdx = 100;
        assertThrows(StringIndexOutOfBoundsException.class,
                () -> stringRequirements.getCharAtIdx(testString, testNegativeIdx));
        assertThrows(StringIndexOutOfBoundsException.class,
                () -> stringRequirements.getCharAtIdx(testString, testPositiveIdx));
    }

    @Test
    @DisplayName("범위에 맞는 문자열 인덱스의 값을 구할 수 있음")
    public void getCharAtValidIdx(){
        String testString = "testing";
        IntStream.range(0,testString.length())
                .forEach((idx) -> assertThat(stringRequirements.getCharAtIdx(testString, idx))
                .isEqualTo(testString.charAt(idx)));
    }

}