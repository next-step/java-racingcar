package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("중복을 허용_하지 않는 Set_컬랙션 크기를 구하는 테스트")
    void find_size_of_set_collection() {
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("특정 숫자가 존재_하는지 찾아_보는 테스트")
    void find_existence_of_a_number_test(int param) {
        assertThat(numbers.contains(param)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false"})
    @DisplayName("입력_값과 기대_값을 넣어 결과를 확인_하는 테스트")
    void parameterized_test(String input1, String input2) {
        int number = Integer.parseInt(input1);
        boolean expected = Boolean.parseBoolean(input2);

        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
