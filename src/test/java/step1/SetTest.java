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
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test()
    @DisplayName("주어진 Set 데이터의 길이를 구하는 테스트")
    void getSize() {
        assertThat(this.numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 Set 내에 특정 값이 존재하는 지 확인하는 테스트")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("파라미터 테스트를 통해서 Set 내에 값이 존재하는 지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containsValueWithParameters(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("특정 값에 따라 다른 결과가 나오는지 확인하는 테스트")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsValueWithInputAndResult(int input, boolean result) {
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
