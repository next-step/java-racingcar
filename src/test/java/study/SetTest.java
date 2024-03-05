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
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("size() 메소드_Set의 크기 확인")
    void setSizeTest() {

        int result = numbers.size();
        // 결과확인
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("contains() 메소드_값이 존재하는지 테스트")
    void containsTest01() {
        assertThat(numbers.contains(1)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("contains() 메소드_값이 존재하는지 테스트")
    @ValueSource(ints = {1,2,3})
    void containsTest02(int num) {
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("contains() 메소드_입력값에 따른 결과값 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTest03(int num, boolean expected) {
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}
