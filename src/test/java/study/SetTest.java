package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("학습 테스트 실습 2단계 - Junit, AssertJ 사용법 숙지")
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

    @ParameterizedTest
    @ValueSource(ints = 3)
    @DisplayName("[요구사항 1] Set 컬렉션의 size() 메서드를 사용하여 Set 크기 확인")
    void validateSetSizeWhenUseSizeMethod(final int expectedSize) {
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("[요구사항 2] Set 컬렉션의 contains() 메서드를 사용하여 특정 원소가 포함되어 있는지 확인")
    void validateContainsSpecificValueInSetWhenUseContainsMethod(final int expectedSize) {
        assertThat(numbers.contains(expectedSize)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
    @DisplayName("[요구사항 3] 요구사항 2를 파라미터에 따라 결과 값도 다르게 테스트")
    void validateContainsDifferentValueInSetWhenUseContainsMethodWithDifferentValueForEachParam(final int givenSize, final boolean expected) {
        assertThat(numbers.contains(givenSize)).isEqualTo(expected);
    }
}
