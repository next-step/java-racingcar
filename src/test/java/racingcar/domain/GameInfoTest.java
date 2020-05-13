package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class GameInfoTest {

    @DisplayName("게임 정보가 0 보다 작을 경우 IllegalArgumentException을 throw 한다.")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "-1, 2", "2, -3"})
    void ThrowException(int numberOfCar, int numberOfPhase) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameInfo(numberOfCar, numberOfPhase))
                .withMessageContaining("0 보다 커야합니다.");
    }
}
