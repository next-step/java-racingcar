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
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("size() 메소드가 3을 반환하는지 테스트")
    @Test
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains() 메소드를 사용해 1,2,3 값이 존재하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTest1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("1, 2, 3 값은 contains() 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTest2(int input, boolean result) {
        assertEquals(numbers.contains(input), result);
    }

}
