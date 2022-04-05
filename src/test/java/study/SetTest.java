package study;

import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("Set 크기 확인 테스트")
    void size() {
        int size = numbers.size();

        assertThat(numbers).hasSize(size);
    }


    @DisplayName("Set Contains 함수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int number) {

        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("Set Contains 함수 CsvSource 적용")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsUpgrade(Integer number, Boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
