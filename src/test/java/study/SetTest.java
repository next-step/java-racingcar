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

@DisplayName("Set Collection에 대한 학습 테스트")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("Set의 사이즈를 반환한다.")
    void size_shouldReturnSetSize() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Set에 존재하는 요소를 체크한다.")
    @ValueSource(ints = {1, 2, 3})
    void contains_shouldReturnTrueWithSpecifiedElementExist(int element) {
        assertThat(numbers.contains(element)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("Set에 존재하는 요소를 체크한다.")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_shouldReturnTheExpectedBoolean(int element, boolean expected) {
        assertThat(numbers.contains(element)).isEqualTo(expected);
    }
}
