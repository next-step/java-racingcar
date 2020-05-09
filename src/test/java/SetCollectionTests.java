import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTests {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size 메소드를 통해 크기 확인가능한지 테스트")
    @Test
    void setSizeMethodTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains 메소드를 통해 내부의 값 존재 여부 확인 가능한지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setContainsTestWithParameterizedTest(int indexNumber) {
        assertThat(numbers.contains(indexNumber)).isTrue();
    }

    @DisplayName("Set contains 메소드에 수행할 수 있는 경우와 수행할 수 없는 경우를 섞어서 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "10:false", "2:true", "100:false", "3:true"}, delimiter = ':')
    void setContainsTestWithValidAndInvalidMixinCase(int targetNumber, boolean result) {
        assertThat(numbers.contains(targetNumber)).isEqualTo(result);
    }
}
