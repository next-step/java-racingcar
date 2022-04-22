package start;

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

    @Test
    @DisplayName("요구사항 1 > Set 의 size() 메소드를 활용해 Set 의 크기를 확인하는 학습테스트를 구현한다.")
    void size() {
        // given
        int size = numbers.size();

        // when / then
        assertThat(size).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2 > Set 의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현, @ParameterizedTest 를 활용해 중복 코드를 제거한다.")
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항 3 > @ParameterizedTest + @CsvSource 활용하여 두 결과를 테스트 할 수 있는 하나의 Test Case 로 구현한다.")
    void contains(int value, boolean hasValue) {
        assertThat(numbers.contains(value)).isEqualTo(hasValue);
    }
}
