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
    @DisplayName("Set의 size 메소드를 활용해 Set의 크기를 확인하는 테스트")
    public void req1() {
        final int validSize = 3;

        assertThat(numbers)
                .hasSize(validSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("Set의 contains 메소드를 활용해 1 ,2, 3의 값 존재 확인")
    public void req2(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("Set의 contains 메소드를 활용해 CsvSource 값 확인")
    public void req3(String input, String expected) {
        assertThat(numbers.contains(Integer.valueOf(input))).isEqualTo(Boolean.valueOf(expected));

    }
}
