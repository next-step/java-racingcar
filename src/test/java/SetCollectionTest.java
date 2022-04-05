import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @DisplayName("size 메서드를 활용해 Set의 크기를 확인하는 테스트")
    void sizeTest() {
        int size = numbers.size();
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("contains 메서드를 활용하여 값이 존재하는지 확인하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    @CsvSource(value = {"1:true", "2:true","3:true","4:false","5:false"}, delimiter = ':')
    void csvTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
