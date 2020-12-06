package study;

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
    @DisplayName("Set Size 확인 테스트")
    void size() {
        assertThat(numbers).size().isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains method를 활용하여 Set Instance 데이터에 포함되는지 확인하는 테스트")
    void contains(Integer integer) {
        assertThat(numbers.contains(integer)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("true 외에도 collection에 존재하지 않는 값이 들어 왔을때 케이스 테스트")
    void contains_falseCaseAdd(Integer input, boolean expected) {
        boolean actualInteger = numbers.contains(input);
        assertThat(actualInteger).isEqualTo(expected);
    }
}
