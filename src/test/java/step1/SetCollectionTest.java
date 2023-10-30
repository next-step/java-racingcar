package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size테스트")
    @Test
    public void setSizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set에 존재하는지 체크")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void setParameterizedTest(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("값에따른 존재여부 반환 체크 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void setParameterizedTest( int value, boolean expected) {
        boolean result = numbers.contains(value);
        assertThat(result).isEqualTo(expected);
    }
}
