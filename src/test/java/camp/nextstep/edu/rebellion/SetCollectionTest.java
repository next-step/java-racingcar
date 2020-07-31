package camp.nextstep.edu.rebellion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size가 정상적으로 크기를 반환하는지 확인")
    @Test
    public void sizeTest() {
        // when & then
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains 가 정상적으로 동작하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsTest(int input) {
        // when & then
        assertTrue(numbers.contains(input));
    }

    @DisplayName("conaints 가 정상적으로 동작하는지 false 상황도 추가하여 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:false",
            "5:false"
    }, delimiter = ':')
    public void containsWithFalseCaseTest(int input, boolean expected) {
        // when & then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
