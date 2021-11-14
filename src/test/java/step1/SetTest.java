package step1;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    // Test Case 구현
    @Test
    @DisplayName("Set 의 크기를 반환한다")
    public void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest(name = "Set 에 {0}이 존재하는지 체크한다")
    @ValueSource(ints = {1, 2, 3})
    public void contains(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "Set 에 {0}이 존재하는지 존재하지 않는지 체크한다")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void ContainOrNot(String input, String expected) {
        Integer parsedInput = Integer.parseInt(input);
        Boolean parsedExpected = Boolean.parseBoolean(expected);

        assertThat(numbers.contains(parsedInput)).isEqualTo(parsedExpected);
    }

}
