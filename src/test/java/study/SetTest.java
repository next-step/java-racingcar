package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Nested
    @DisplayName("요구사항 1")
    class Requirement1 {

        @Test
        @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습 테스트")
        void size() {
            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class Requirement2 {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습 테스트")
        void contains(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class Requirement3 {

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("Set의 contains() 메소드를 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
        void contains2(int number, boolean expected) {
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }
    }
}
