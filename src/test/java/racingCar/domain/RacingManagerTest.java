package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingManagerTest {
    @DisplayName("최대 시도횟수가 되면 게임을 진행할 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"2, false", "3, true"})
    void canPlay(int maxCount, boolean canPlay) {
        CarGroup carGroup = CarGroup.from(List.of("pobi","crong"));
        TryCount tryCount = TryCount.from(maxCount);
        MovementGenerator movementGenerator = new MovementGenerator(new RandomNumberGenerator());
        RacingManager racingManager = new RacingManager(carGroup, tryCount, movementGenerator);

        racingManager.playTurn();
        racingManager.playTurn();

        assertThat(racingManager.canPlay()).isEqualTo(canPlay);
    }

}
