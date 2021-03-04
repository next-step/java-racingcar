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

    @DisplayName("[요구사항1]size() 메소드 활용 Set 크기 확인")
    @Test
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("[요구사항2]contains()를 활용하여 1,2,3의 값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsTest_1(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("[요구사항3]contains()를 활용하여 값이 있을 경우에는 true, 없을 경우에는 false 반환 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void containsTest_2(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
