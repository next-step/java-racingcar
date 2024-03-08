import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("step01 - Set Collection에 대한 학습테스트")
public class SetCollectionPlaygroundTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("요구사항1 - size() 메소드를 활용 Set 크기 테스트")
    @Test
    public void setSize_TestSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    private static Stream<Arguments> paramsForContainsTest() {
        return Stream.of(
                Arguments.of(1),
                Arguments.of(2),
                Arguments.of(3)
        );
    }

    @DisplayName("요구사항2 - contains() 메소드를 활용 1,2,3 값 존재 확인 테스트, ParameterizedTest - MethodSource 활용")
    @ParameterizedTest
    @MethodSource("paramsForContainsTest")
    public void setContains_TestWithMethodSource(int value) {
        assertThat(numbers).contains(value);
    }

    @DisplayName("요구사항2 - contains() 메소드를 활용 1,2,3 값 존재 확인 테스트, ParameterizedTest - ValueSource 활용")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setContains_TestWithValueSource(int value) {
        assertThat(numbers).contains(value);
    }

    @DisplayName("요구사항3 - contains() 메소드를 활용하여 입력값에 따라 결과값이 다른 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    public void setContains_ReturnTrueIfValueIsPresentInNumbers(int value, boolean expected) {
        assertEquals(expected, numbers.contains(value));
    }


}
