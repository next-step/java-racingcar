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

public class SetCollectionTest {
    private Set numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @DisplayName("Set의 크기를 측정한다.")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("예측되는 값을 모두 포함하고 있는지 체크한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int item) {
        assertThat(numbers.contains(item)).isTrue();
    }

    @DisplayName("Set에 포함되어있지 않은 값도 테스트해본다.")
    @ParameterizedTest
    @CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsWithMatchedValue(int item, boolean expect) {
        assertThat(numbers.contains(item)).isEqualTo(expect);
    }
}
