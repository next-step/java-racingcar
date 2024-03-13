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

@DisplayName("Set Collection을 테스트합니다.")
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
    @DisplayName("size()를 호출했을 때 기대한 integer를 반환한다.")
    public void shouldReturnInteger_whenCallSizeMethod(){
        int output = numbers.size();
        int expectedOutput = 3;

        assertThat(output).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("integer 값이 주어졌을 때, 포함되었으면 true를 반환한다.")
    public void shouldReturnTrue_givenIntegerValue(int value){
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("integer 값이 주어졌을 때, 포함되었으면 true 아니면 false를 반환한다.")
    public void shouldReturnBoolean_givenIntegerValue(int value, boolean expected){
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }

}
