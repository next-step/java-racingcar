package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
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

    @Test
    @DisplayName("Set의 사이즈가 동일하면 성공한다.")
    void shouldSuccessSizeIsSame(){
        Assertions.assertEquals(numbers.size(), 3);
    }

    @Test
    @DisplayName("contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인한다")
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }


    @ParameterizedTest(name = "numbers.contains({0}) == true")
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("리스트에 포함된 숫자는 contains()가 true를 반환한다")
    void shouldSuccessInputAndNumberContain(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest(name = "{index} => numbers.contains({0}) == {1}")
    @CsvSource(value = {
        "1:true",
        "2:true",
        "3:true",
        "4:false",
        "5:false"
    }, delimiter = ':')
    @DisplayName("리스트에 포함된 숫자는 true, 포함되지 않으면 false를 반환한다")
    void shouldReturnExpectedResultBasedOnInput(int input, boolean expected) {
        // when
        boolean actual = numbers.contains(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}
