package calculator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveTest {

    @Nested
    class 생성자는 {

        @Nested
        class 양수_문자가_주어지면 {

            @Test
            void 변환된_양수를_리턴한다() {
                assertThat(new Positive("1"))
                        .isEqualTo(new Positive("1"));
            }
        }

        @Nested
        class 숫자가_아니거나_음수_문자가_주어지면 {

            @ParameterizedTest
            @ValueSource(strings = {"-1", "a"})
            void RuntimeException을_던진다(String value) {
                assertThatThrownBy(() -> new Positive(value))
                        .isInstanceOf(RuntimeException.class);
            }
        }
    }
}
