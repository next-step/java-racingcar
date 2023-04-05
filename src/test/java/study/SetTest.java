package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

    // Test Case 구현
    @Test
    @DisplayName("[요구사항 1] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
    void 요구사항_1() {
        // given
        final int SIZE = 3;

        // when, then
        assertThat(numbers.size()).isEqualTo(SIZE);
    }

    @Test
    @DisplayName("[요구사항 2-1] Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 테스트")
    void 요구사항_2_1() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("[요구사항 2-2] (중복 코드 제거) Set의 contains() 메소드를 활용해 1,2,3의 값이 존재하는지를 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void 요구사항_2_2(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("[요구사항 3] contains() 메소드가 true, false 모두 반환할 수 있는지 확인하는 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void 요구사항_3(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
