package testpractice;

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
    @DisplayName(value = "Size()메서드로 크기 확인 테스트")
    public void checkSizeEqualTest() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest(name = "1,2,3값 존재여부 ParameterizedTest로 중복 제거 테스트 {index}번쨰값 : {0}")
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest(name = "parameterizedTest t케이스 테스트 {index}번쨰값 : {0}")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
    void containsIncludeData(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }


}

