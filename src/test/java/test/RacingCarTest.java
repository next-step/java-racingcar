package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Car;
import racingCar.domain.RacingGame;
import racingCar.view.InputView;

public class RacingCarTest {

    private final int MOVABLE_NUMBER = 4;

    @DisplayName("경주0바퀴")
    @Test
    void race_0() {
        RacingGame racingGame = new RacingGame("pobi,woni,jun");
        racingGame.race(racingGame.getCars(), 0);
        assertThat(racingGame.getTryCount()).isZero();

    }
    @DisplayName("경주5바퀴")
    @Test
    void race_5() {
        RacingGame racingGame = new RacingGame("pobi,woni,jun", 5);
        racingGame.race(racingGame.getCars(), 5);
        assertThat(racingGame.getTryCount()).isEqualTo(5);

    }

    @DisplayName("자동차들 중에서 가장 멀리 간 차를 알 수 있다.")
    @Test
    void far() {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        RacingGame racingGame = new RacingGame("pobi,woni,jun");

        racingGame.getCars().get(0).move(MOVABLE_NUMBER);
        racingGame.getCars().get(0).move(MOVABLE_NUMBER);
        racingGame.getCars().get(1).move(MOVABLE_NUMBER);
        racingGame.getCars().get(1).move(MOVABLE_NUMBER);
        racingGame.getCars().get(1).move(MOVABLE_NUMBER);
        racingGame.getCars().get(2).move(MOVABLE_NUMBER);
        racingGame.getCars().get(2).move(MOVABLE_NUMBER);
        racingGame.getCars().get(2).move(MOVABLE_NUMBER);

        assertThat(racingGame.getWinners(racingGame.getCars()).toString()).isEqualTo("[woni, jun]");
    }
}
