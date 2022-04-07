package calculator;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveTest {

    @Nested
    class 생성자는 {

        @Nested
        class 양수_문자가_주어지면 {

            @Test
            void 변환된_양수를_리턴한다() {
                assertThat(new Positive("1")).isEqualTo(1);
            }
        }

        @Nested
        class 음수_문자가_주어지면 {

            @Test
            void RuntimeException을_던진다() {
                assertThatThrownBy(() -> new Positive("-1"))
                        .isInstanceOf(RuntimeException.class);
            }
        }

        @Nested
        class 숫자가_아닌_값이_주어지면 {

            @Test
            void NumberForMatException을_던진다() {
                assertThatThrownBy(() -> new Positive("a"))
                        .isInstanceOf(NumberFormatException.class);
            }
        }
    }
}
