package woowacamp.racingcar.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @ValueSource(strings = {"규", "충규충규충"})
    @ParameterizedTest
    void 이름은_한_글자에서_다섯_글자_사이어야_한다(String value) {
        Name name = new Name(value);

        assertThat(name.getValue()).isEqualTo(value);
    }

    @ValueSource(strings = {"일이삼사오육", "일이삼사오육칠팔구"})
    @ParameterizedTest
    void 이름은_다섯_글자보다_길면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 이름이_null이거나_공백이면_예외가_발생한다(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
