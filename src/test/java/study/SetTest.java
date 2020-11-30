package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}
