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

class SetTest {
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
    @DisplayName("size() 로 Set 의 크기를 확인한다.")
    void requirement_1() {
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("contains() 로 1, 2, 3의 값이 존재하는지 확인한다.")
    void requirement_2_1() {
        assertThat(numbers).contains(1);
        assertThat(numbers).contains(2);
        assertThat(numbers).contains(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("@ParameterizedTest 로 중복되는 assertion 을 제거한다.")
    void requirement_2_2(int number) {
        assertThat(numbers).contains(number);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    @DisplayName("성공 케이스와 실패 케이스를 동시에 테스트한다.")
    void requirement_2_3(int number, boolean result) {
        assertThat(numbers.contains(number)).isEqualTo(result);
    }

}
