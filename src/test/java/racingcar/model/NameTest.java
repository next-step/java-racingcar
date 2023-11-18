package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {

        @Test
        void 다섯글자_이상의_이름_입력_시_에러() {
                assertThatThrownBy(() -> new Name("aaaaaa")).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("5자 이하만 입력가능합니다.");
        }
}
