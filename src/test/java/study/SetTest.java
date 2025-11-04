package study;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    @DisplayName("요구사항 1 : set 의 size 활용")
    void setSizeTest() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

//    @Test
//    @DisplayName("요구사항 2 : set 의 contain 메소드 활용")
//    void setContainsTest() {
//        assertThat(numbers.contains(1)).isTrue();
//        assertThat(numbers.contains(2)).isTrue();
//        assertThat(numbers.contains(3)).isTrue();
//    }

//    @Test // 제거
    @ParameterizedTest
    @DisplayName("요구사항 2 : set 의 contain 메소드 활용 / 중복 코드 제거")
    @ValueSource(ints = {1, 2, 3})
    void isContain_numbers_in_set(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항 3 : contains 메소드의 결과 값이 true 이거나 false")
    @CsvSource(value = {"1:'true'", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains(String num, String expected) {
        int parseInt = Integer.parseInt(num);
        boolean parseBoolean = Boolean.parseBoolean(expected);
        assertThat(numbers.contains(parseInt)).isEqualTo(parseBoolean);
    }
}
