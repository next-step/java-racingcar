package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SetCollectionTest {
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
    @DisplayName("요구사항 1 - size메소드를 활용해 Set크기 확인")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항 2 - contains메소드를 활용해 값 존재 확인, ParameterizedTest 활용해 중복 코드 제거")
    @ValueSource(strings = {"1","2","3"})
    void contains_happy(String input) {
        assertThat(input).contains("1","2","3");
    }

    @ParameterizedTest
    @DisplayName("요구사항 3 - 요구사항2를 토대로 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    @CsvSource(value = {"true:1", "4:2", "5:3"}, delimiter = ':')
    void contains_blue(String input, String expected) {
        assertThat(input).doesNotContain(expected);
    }
}
