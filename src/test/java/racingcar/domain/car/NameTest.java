package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {

    @Test
    void 다섯글자_를_초과하는_이름을_전달받는경우_생성에_실패한다() {
        String invalidName = "123456";

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(invalidName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 비어있거나_null_인_문자열을_전달받는_경우_생성에_실패한다(String invalidName) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Name(invalidName));
    }

}
