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

    // Test Case 구현
    @Nested
    @DisplayName("Set 관련 테스트를 진행한다.")
    class test {
        @Test
        @DisplayName("Set 의 크기를 확인한다")
        void check_set_size() {
            assertThat(numbers.size()).isEqualTo(3);
            assertThat(numbers).hasSize(3);
        }

        @Nested
        @DisplayName("준비된 요소들을 차례로 set 안에 넣었을 때,")
        class check_number_is_existed_in_set_ {
            @ParameterizedTest
            @ValueSource(ints = {1, 2, 3})
            @DisplayName("해당 요소가 set 안에 존재한다.")
            void check_components(int i) {
                assertThat(numbers).contains(i);
            }

            @ParameterizedTest
            @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
            @DisplayName("해당 요소가 set 안에 있을지 없을지 답을 확인한다.")
            void test(int i, boolean answer) {
                assertThat(numbers.contains(i)).isEqualTo(answer);
            }
        }
    }
}
