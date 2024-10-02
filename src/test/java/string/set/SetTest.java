package string.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메소드로 Set의 크기를 확인할 수 있다.")
    @Test
    void size() {

        // given & when
        int result = numbers.size();

        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("contains 메소드로 set에 원하는 값이 포함되었는지 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {

        //given &  when
        boolean result = numbers.contains(num);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("contains 메소드로 set에 원하는 값이 포함되었는지 아닌지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsWithExpected(int num, boolean expected) {

        // given & when
        boolean result = numbers.contains(num);

        // then
        assertThat(result).isEqualTo(expected);

    }
}