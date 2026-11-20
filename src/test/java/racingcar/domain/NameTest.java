package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 이름이_5자를_초과하면_예외를_던진다() {
        assertThatThrownBy(() -> new Name("longname"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름이_5자_이하이면_정상적으로_생성된다() {
        assertThat(new Name("pobi").getValue()).isEqualTo("pobi");
    }
}