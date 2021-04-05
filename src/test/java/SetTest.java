import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;


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
    public void example() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @Test
    @DisplayName("set의 크기 확인")
    public void 요구사항_1() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("contains()를 활용한 1,2,3 존재 유무 테스트 중복 코드 제거")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 요구사항_2(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    public void 요구사항_3(int input, boolean expected) {
        boolean result = numbers.contains(input);
        assertThat(result).isEqualTo(expected);
    }

}

