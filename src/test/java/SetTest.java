import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set")
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

    @Nested
    @DisplayName("size()")
    class SizeTest {

        @Test
        @DisplayName("numbers의 size 함수를 사용하면 3을 반환한다.")
        void test01() {
            // when
            final var size = numbers.size();

            // then
            assertThat(size).isEqualTo(3);
        }

    }

    @Nested
    @DisplayName("contains()")
    class ContainsTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("numbers에 1, 2, 3이 존재한다.")
        void test01(final int number) {
            // when & then
            assertThat(numbers).contains(number);
        }

        @ParameterizedTest
        @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
        @DisplayName("numbers에 1, 2, 3은 존재하고 4, 5는 존재하지 않는다.")
        void test02(final int number, final boolean expected) {
            // when & then
            assertThat(numbers.contains(number)).isEqualTo(expected);
        }

    }

}
