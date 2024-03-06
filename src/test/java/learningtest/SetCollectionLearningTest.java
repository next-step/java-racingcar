package learningtest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 학습 테스트")
public class SetCollectionLearningTest {

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
    @DisplayName("size() 메서드 학습 테스트")
    class SizeTest {

        @Test
        @DisplayName("Set size() 메서드로 크기 확인")
        void assertSetSizeThroughSetSizeMethod() {
            assertThat(numbers.size()).isEqualTo(3);
        }

        @Test
        @DisplayName("AssertJ hasSize() 메서드로 크기 확인")
        void assertSetSizeThroughAssertJHasSizeMethod() {
            assertThat(numbers).hasSize(3);
        }
    }

    @Nested
    @DisplayName("contains() 메서드 학습 테스트")
    class ContainsTest {

        @Test
        @DisplayName("Set contains() 메서드를 중복해서 사용하여 원소 확인")
        void assertSetElementThroughSetContains() {
            assertThat(numbers.contains(1)).isTrue();
            assertThat(numbers.contains(2)).isTrue();
            assertThat(numbers.contains(3)).isTrue();
        }

        // 하나의 검증 대상에 대해 반복적인 패턴으로 여러 값들을 넣어서 검증해야 한다면
        // @ParameterizedTest 를 통해 테스트 코드 가독성을 높일 수 있다.
        @DisplayName("@ParameterizedTest + @ValueSource 활용하여 원소 확인")
        @ParameterizedTest(name = "{index} ==> Set contains {0} is true.")
        @ValueSource(ints = {1, 2, 3})
        void assertSetElementThroughParameterizedTest(Integer number) {
            assertThat(numbers.contains(number)).isTrue();
        }

        @DisplayName("@ParameterizedTest + @CsvSource 활용하여 원소 확인")
        @ParameterizedTest(name = "{index} ==> Set contains {0} is {1}.")
        @CsvSource(value = {"1:true", "2:true", "-9999:false", "3:true"}, delimiter = ':')
        void assertSetElementThroughParameterizedTest(Integer number, Boolean expected) {
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }

        @Test
        @DisplayName("AssertJ containsExactlyInAnyOrder() 활용하여 원소 확인")
        void assertSetElementThroughAssertJContains() {
            assertThat(numbers).containsExactlyInAnyOrder(1, 2, 3);
        }

    }
}
