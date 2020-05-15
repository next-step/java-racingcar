package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.game.GameInfo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameInfoTest {

    @DisplayName("이름이 입력되지 않으면 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyNameThrowsException(String nameOfCars) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameInfo(nameOfCars, 3))
                .withMessageContaining("자동차 이름을 입력해주세요.");
    }

    @DisplayName("시도 회수 0 보다 작을 경우 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -3})
    void ThrowException(int numberOfPhase) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameInfo("pobi", numberOfPhase))
                .withMessage("시도할 횟수는 0 보다 커야합니다.");
    }
}
