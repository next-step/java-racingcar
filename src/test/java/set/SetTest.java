package set;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("set size() 로 set 크기를 구할 수 있다.")
    void set_requirement1() {

        // Given
        int expected = 3;
        int sizeOfSet = numbers.size();

        // When & Then
        assertThat(expected).isEqualTo(sizeOfSet);
    }

    @ParameterizedTest(name = "set 의 요소를 검사한다.")
    @ValueSource(ints = {1, 2, 3})
    void set_requirement2(int argument) {
        assertThat(numbers.contains(argument)).isTrue();
    }


}
