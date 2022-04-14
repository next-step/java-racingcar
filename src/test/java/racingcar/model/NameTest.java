package racingcar.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NameTest {

    @Nested
    class 생성자는 {

        @Nested
        class _5자가넘는_문자열이_주어질_경우 {
            private static final String FIVE_STRING_LENGTH_MORE = "123456";

            @Test
            void IllegalArgumentException을_던진다() {
                assertThatIllegalArgumentException()
                        .isThrownBy(() -> new Name(FIVE_STRING_LENGTH_MORE));
            }
        }

        @Nested
        class _5자이하_문자열이_주어질_경우 {
            private static final String FIVE_STRING_LENGTH_OR_LESS = "12345";

            @Test
            void 이름을_리턴한다() {
                assertThat(new Name(FIVE_STRING_LENGTH_OR_LESS))
                        .isEqualTo(new Name(FIVE_STRING_LENGTH_OR_LESS));
            }
        }
    }
}
