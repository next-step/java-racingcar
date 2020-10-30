package firstStage;

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

/**
 * 자동차 경주
 * 1단계 - 학습 테스트
 * Set Collection
 */
public class SetCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        // given
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName(value = "[요구사항 1] : Set의 size() 메서드를 활용해 Set의 크기를 확인")
    @Test
    void size() {
        // when
        int size = numbers.size();

        // then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName(value = "[요구사항 2] : ParameterizedTest의 @ValueSource를 활용해 중복을 제거한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_ShouldReturnTrueForOddNumbers(int number) {
        // then
        assertTrue(numbers.contains(number));
    }

    @DisplayName(value = "[요구사항 3] : ParameterizedTest의 @CsvSource를 활용해 true, false 인 경우 모두 테스트 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_ShouldReturnTrueForOddNumbers(int number, boolean expected) {
        // then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
