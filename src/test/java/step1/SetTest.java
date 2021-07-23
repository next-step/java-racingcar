package step1;

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
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메소드 정상동작 테스트")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("setup 메소드에서 초기화한 값을 포함하고 있는지 테스트")
    @ParameterizedTest(name = "{index} {displayName}")
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers).contains(input);
    }

    @DisplayName("setup 메소드에서 초기화한 값을 포함하면 true, 그 외 값의 경우 false 리턴")
    @ParameterizedTest(name = "{index} {displayName}")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_ShouldSetupValueReturnTrueAndOthersReturnFalse(int input, boolean expected) {
        boolean actualValue = numbers.contains(input);
        assertThat(actualValue).isEqualTo(expected);
    }
}
