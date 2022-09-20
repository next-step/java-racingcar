package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("요구사항1 - Set의 크기를 확인한다.")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("요구사항2 - 1, 2, 3의 값이 존재하는지를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("요구사항3 - 입력값에 따라 contains true/false 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"-1:false, 0:false, 1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void csvValueOfContainsTest(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }

}
