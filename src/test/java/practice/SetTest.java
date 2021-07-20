package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Set Collection에 대한 학습 테스트")
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

    @DisplayName("Set의 size() 메소드를 사용해 Set의 크기를 확인할 수 있다.")
    @Test
    void getSetSizeTest() {
        // when
        int numbersSize = numbers.size();

        // then
        assertThat(numbersSize).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 사용해 특정 값이 존재하는지 확인할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void confirmSpecificValueExistenceTest(Integer number) {
        // then
        assertTrue(numbers.contains(number));
    }

    @DisplayName("Set의 contains() 메소드를 사용해 특정 값의 존재 여부를 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    void confirmSpecificValueExistenceTest(Integer number, boolean numberExists) {
        // then
        assertThat(numbers.contains(number)).isEqualTo(numberExists);
    }
}
