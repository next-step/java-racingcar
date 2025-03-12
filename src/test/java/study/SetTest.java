package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

    // Test Case 구현
    @Test
    @DisplayName("요구사항 1: Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void req1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항 2: Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하되, ParameterizedTest를 활용해 중복 코드를 제거")
    @ValueSource(ints = {1, 2, 3})
    void req2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항3: 요구사항 2에서 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False"}, delimiter = ':')
    void req3(String input, String expected) {
        // given
        Integer i = Integer.parseInt(input);
        Boolean e = Boolean.parseBoolean(expected);

        // when

        // then
        assertThat(numbers.contains(i)).isEqualTo(e);
    }
}
