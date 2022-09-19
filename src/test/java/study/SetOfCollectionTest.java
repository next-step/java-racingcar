package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetOfCollectionTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Nested
    @DisplayName("요구사항 1")
    class FirstRequirements {

        @Test
        @DisplayName("Collection Size 테스트")
        void isSize_ShouldReturn3FromExampleSet() {
            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class SecondRequirements {

        @ParameterizedTest
        @ArgumentsSource(NumberElementProvider.class)
        @DisplayName("Contain함수를 실행할때 NumberElementProvider의 요소가 포함되면 True를 반환한다")
        void isContain_ShouldReturnTrueForContainFromNumberElementProvider(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("Contain함수를 실행할때 Value Source의 요소가 포함되면 True를 반환한다.")
        void isContain_ShouldReturnTrueForContainFromValueSource(int number) {
            assertThat(numbers.contains(number)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class ThirdRequirements {

        @ParameterizedTest
        @CsvSource(value = {"1,TRUE", "2,TRUE", "3,TRUE", "4,FALSE", "5,FALSE"})
        @DisplayName("Contain함수를 실행할때 포함된 요소이면 True를 반환하고 포함되지 않으면 False를 반환한다")
        void isContain_ShouldReturnTrueForContainOrFalseForNotContain(int number, boolean expected) {
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }
    }
}
