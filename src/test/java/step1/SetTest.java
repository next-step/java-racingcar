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

    @Test
    @DisplayName("Set의 크기 확인")
    void Set_크기_확인() {
        // When
        int size = numbers.size();

        // Then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest(name = "Set에 숫자 {arguments} 존재")
    @DisplayName("숫자 1,2,3 값이 Set에 존재하는지 확인")
    @ValueSource(ints = {1,2,3})
    void 숫자_1_2_3_값_존재_확인(int input) {
        // When
        boolean result = numbers.contains(input);

        // Then
        assertThat(result);
    }

    @DisplayName("입력값과 Set이 가진 값 비교")
    @ParameterizedTest(name = "입력값이 {0}일 때, {1}를 반환")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void 입력값과_Set의_값_비교(int input, boolean expected) {
        // When
        boolean result = numbers.contains(input);

        // Then
        assertThat(result);
    }
}
