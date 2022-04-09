import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    }

    @DisplayName("요구사항1. set size 테스트")
    void isSetSize(int input) {
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(numbers.size()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2. set contain 테스트 ParameterizedTest 이용")
    void isContain(int input) {
        numbers.add(input);
        assertThat(numbers.contains(input)).isTrue();
    }

    //
    @ParameterizedTest
    @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
    @DisplayName("요구사항3. set contain 테스트2")
    void isContainExpected(String input, String expected) {
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Assertions.assertEquals(numbers.contains(Integer.parseInt(input)), Boolean.parseBoolean(expected));
    }

}



