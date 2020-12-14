package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    void 자동차_이름_생성() {
        Name name = new Name("a");
        assertThat(name).isEqualTo(new Name("a"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"메르세데스벤츠"," "})
    void 자동차이름_예외처리(String carName) {
        assertThatThrownBy(() -> new Name(carName)).isInstanceOf(IllegalArgumentException.class);
    }
}
