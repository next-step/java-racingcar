package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Set Collection에 대한 학습 테스트
 */
class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    @Test
    void setSizeTest() {
        // When
        int numbersSize = numbers.size();

        // Then
        assertThat(numbersSize).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3 값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContainsTest(int number) {
        // When
        boolean isContained = numbers.contains(number);

        // Then
        assertThat(isContained).isTrue();
    }

    @DisplayName("Set의 contains() 메소드를 활용해 값이 존재하는지 아닌지 확인")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void setContainsWithCsvTest(int num, boolean expected) {
        // When
        boolean isContained = numbers.contains(num);

        // Then
        assertThat(isContained).isEqualTo(expected);
    }
}
