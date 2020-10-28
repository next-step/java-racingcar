package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import java.util.HashSet;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("Set 의 size() 메소드를 활용해 Set 의 크기를 확인")
    void checkSize() {
        assertThat(numbers.size())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("Set 의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void checkElements() {
        assertThat(numbers.contains(1))
                .isTrue();
        assertThat(numbers.contains(2))
                .isTrue();
        assertThat(numbers.contains(3))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("ParameterizedTest 를 활용해 checkElements 의 중복 코드를 제거")
    @ValueSource(ints = {1, 2, 3})
    void checkValueSourceElements(int input) {
        assertThat(numbers.contains(input))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("CsvSource 를 활용해 입력 값에 따라 결과 값이 다른 경우에 대한 checkElements 테스트 구현")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void checkCsvSourceElements(int input, boolean expected) {
        assertThat(numbers.contains(input))
                .isEqualTo(expected);
    }
}
