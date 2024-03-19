package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DriverTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("참가자 이름 미입력시 에러를 던진다.")
    void create_NullOrEmpty(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Driver.from(name))
                .withMessageMatching("참가자 이름을 입력하세요.");
    }
}