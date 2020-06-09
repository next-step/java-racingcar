package racing.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.RacingCars;
import racing.domain.test.TestCarForwardBehavior;
import racing.domain.test.TestCarStopBehavior;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    RacingCars racingCars = new RacingCars("car1,car2,car3");
    RacingGame racingGame = new RacingGame(racingCars);

    @BeforeEach
    void setUp() {
        racingCars.getCars().get(0).move(new TestCarForwardBehavior());
        racingCars.getCars().get(0).move(new TestCarForwardBehavior());

        racingCars.getCars().get(1).move(new TestCarForwardBehavior());
        racingCars.getCars().get(1).move(new TestCarStopBehavior());

        racingCars.getCars().get(2).move(new TestCarForwardBehavior());
        racingCars.getCars().get(2).move(new TestCarForwardBehavior());
    }

    @Test
    @DisplayName("maxPosition 확인")
    void findMaxPositionTest() {
        assertThat(racingGame.findMaxPosition(racingCars)).isEqualTo(2);
    }

}
