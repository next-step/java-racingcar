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

@DisplayName("Step1. Set Collection에 대한 학습 테스트")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드는 empty하지 않으면 0보다 큰 정수를 반환한다")
    @Test
    void setCollectionSizeTest() {
        assertThat(numbers.size())
                .isGreaterThan(0)
                .isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드는 값이 존재하면 TRUE를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void setCollectionContainsTest1(int existValue) {
        assertThat(numbers.contains(existValue)).isTrue();
    }

    @DisplayName("Set의 contains() 메소드는 값 존재 유무에 따라서 TRUE 또는 FALSE를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    void setCollectionContainsTest2(int value, boolean expectedResult) {
        assertThat(numbers.contains(value)).isEqualTo(expectedResult);
    }
}
