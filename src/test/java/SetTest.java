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

    @DisplayName("Set::size 함수는 Set class 내부의 item 개수를 반환한다")
    @Test
    public void size_Set_shouldSucceedAndReturnSize() {
        int expected = 3;
        int result = numbers.size();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Set::contains 함수는 item을 포함하고 있으면 True를 반환한다")
    @ParameterizedTest(name = "{0} should be True")
    @ValueSource(ints = {1, 2, 3})
    public void contatins_Set_shouldSucceedAndReturnTrue(Integer item) {
        assertThat(numbers.contains(item)).isTrue();
    }

    @DisplayName("Set::contains 함수는 item의 포함 여부를 반환한다")
    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    public void contatins_Set_shouldSucceed(String input, String expected) {
        assertThat(numbers.contains(Integer.getInteger(input))).isEqualTo(Boolean.getBoolean(expected));
    }

}
