package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetStudyTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("Set Size 맞을 경우 테스트")
    void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4})
    @DisplayName("contains 테스트")
    void containsTest(Integer input) {
        assertThat(numbers).contains(input);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 4})
    @DisplayName("contains 테스트")
    void setContainsTest(Integer input) {
        assertThat(numbers.contains(input)).isTrue();
    }

}
