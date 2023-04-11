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

    @DisplayName("Set size() 메서드를 활용해 Set 크기 확인")
    @Test
    void setSize() {
        int size = numbers.size();
        assertThat(size).isEqualTo(4);
    }

    @DisplayName("ParameterizedTest 활용해 중복 코드 제거 후 1,2,3의 값이 존재하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int input) {
        assertThat(numbers.contains(input));
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void ShouldGenerateTheExpectedBooleanValue(int input, boolean expected) {
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
