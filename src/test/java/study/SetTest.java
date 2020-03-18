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

@DisplayName("Set Collection 학습 테스트")
public class SetTest {

    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    void containsTest(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "4,false"})
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    void csvInputAndExpected(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }

}
