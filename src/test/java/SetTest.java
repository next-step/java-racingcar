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

    // Test Case 구현
    @Test
    @DisplayName("요구사항1 - Set의 size 메서드를 호출하면 Set의 크기를 반환한다.")
    public void setSizeTest() {
        int expectedSize = 3;
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항2 - Set의 contains 메서드 학습 테스트 - ValueSource를 이용한 ParameterizedTest")
    void containsTest(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("요구사항3 - Set의 contains 메서드 학습 테스트 - CsvSource를 이용한 ParameterizedTest")
    void containsCsvSourceTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
