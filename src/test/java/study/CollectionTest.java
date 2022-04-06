package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class CollectionTest {

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
    @DisplayName("요구사항1, size() 메소드 테스트")
    void sizeTest() {
        Assertions.assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항2, contains() 메소드 테스트")
    void containsTest() {
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(1)).isTrue();
        Assertions.assertThat(numbers.contains(2)).isTrue();
        Assertions.assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항2, ParameterizedTest를 활용한 contains() 메소드 테스트")
    @ValueSource(ints = {1,1,2,3})
    void parameterizedTest(int input) {
        Assertions.assertThat(numbers.contains(input)).isTrue();
    }


    @ParameterizedTest
    @DisplayName("요구사항3, ParameterizedTest를 활용한 contains() 메소드 테스트(false 테스트 포함)")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void parameterizedTestWithFalse(int input, boolean expected) {
        Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
