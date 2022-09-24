package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set의 size() 메서드로 정확한 크기를 가져오는데 성공하는 케이스")
    public void dateTypeSetSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    @DisplayName("Parameterized 테스트를 사용해 Set에 들어있는 모든 값을 확인하는데 성공하는 케이스")
    public void dataTypeSetContainsWithParameterizedTest(int value) {
        assertThat(numbers).contains(value);
    }

    @ParameterizedTest
    @CsvSource({ "1,true", "2,true", "3,true", "4,false", "5,false" })
    @DisplayName("Set에 들어있는지 확인하며, 값이 있을 수도 없을 수도 있는 모든 경우를 대비하는 케이스")
    public void dateTypeSetContainsWithParameterizedBothSuccessAndFailTest(int value, boolean expectedResult) {
        boolean result = numbers.contains(value);
        assertThat(result).isEqualTo(expectedResult);
    }
}
