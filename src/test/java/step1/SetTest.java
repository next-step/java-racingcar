package step1;

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

    // Test Case 구현 부

    @Nested
    @DisplayName("요구사항 1")
    class step1 {

        @Test
        @DisplayName("Set의 size를 확인 할 수 있다.")
        void verifySetSizeTest() {
            assertThat(numbers.size()).isEqualTo(3);
        }
    }

    @Nested
    @DisplayName("요구사항 2")
    class step2 {

        @ParameterizedTest
        @DisplayName("Set의 value `1, 2, 3`을 contains 메서드를 통해 확인 할 수 있다.")
        @ValueSource(ints = {1, 2, 3})
        void verifyParameterizedTest(int num) {
            assertThat(numbers.contains(num)).isTrue();
        }
    }

    @Nested
    @DisplayName("요구사항 3")
    class step3 {

        @ParameterizedTest
        @DisplayName("cotains 메소드 실행시 `1, 2, 3`은 true `4, 5`는 false를 반환한다.")
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        void verifyCsvSourceTest(int num, boolean expected) {
            assertThat(numbers.contains(num)).isEqualTo(expected);
        }
    }

}
