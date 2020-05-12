package step1;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(1);
    }

    @DisplayName("size 테스트")
    @Test
    public void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("true 인 경우만 테스트 가능하다")
    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void trueOnlyTest(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
