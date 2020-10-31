package study.step1;

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
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인한다")
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
        numbers.clear();
        assertThat(numbers.size()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("JUnit의 ParameterizedTest와 @ValueSource를 활용해 중복 코드를 제거해 본다.")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("@CsvSource를 활용해 네거티브 테스트를 추가해 본다.")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void contains(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
