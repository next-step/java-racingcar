package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.FixedMovingStrategy;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:3","1:4","0:4"}, delimiter = ':')
    @DisplayName("자동차 move 테스트")
    void move(int movableCount,int totalMovingTryCount) {
        RacingCar test = new RacingCar("test", new FixedMovingStrategy(movableCount, totalMovingTryCount - movableCount));
        for (int i = 0; i < totalMovingTryCount; i++) {
            test.move();
        }
        assertThat(test.getTravelledDistance()).isEqualTo(movableCount);
    }
}
