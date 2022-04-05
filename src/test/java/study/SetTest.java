package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

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
    class 요구사항1 {

        @Test
        @DisplayName("성공 - Set의 사이즈는 3")
        void test1() {
            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class 요구사항2 {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("성공 - Set Collection엔 1, 2, 3 값이 존재한다.")
        void test1(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class 요구사항3 {

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("성공 - Set Collection엔 1,2,3 이 들어있고 4,5 는 없다.")
        void test1(int number, Boolean expected) {
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }

    }
}
