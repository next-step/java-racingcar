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
    @DisplayName("set size() 메소들을 활용하여 set의 크기 확인")
    void setSizeMethod() {
        int setExpectSize = 3;
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @DisplayName("set 객체가 포함하고 있는 항목 확인")
    @ValueSource(ints = {1, 2, 3})
    void setContainsItemCheck(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력값에 따른 서로 다른 결과값 확인")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void test(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
