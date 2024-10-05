package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new FourOrMore(new TestRandomHolder(4)));
    }

    @Test
    @DisplayName("시도 횟수별 자동차의 위치를 기록한다.")
    void race() {
        List<Car> cars = Arrays.asList(new Car("pobi"), new Car("crong"), new Car("honux"));
        int attemptCount = 5;

        RaceResult raceResult = racingGame.race(cars, attemptCount);

        for (int i = 0; i < raceResult.getAttemptResults().size(); i++) {
            for (Car car : raceResult.getAttemptResults().get(i).getCarPositions()) {
                assertThat(car.getPosition()).isEqualTo(i + 1);
            }
        }
    }

    @Test
    @DisplayName("쉼표로 구분된 문자열로 자동차를 생성한다.")
    void createCars() {
        String carNames = "pobi,crong,honux";
        List<Car> cars = racingGame.createCars(carNames);
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("crong");
        assertThat(cars.get(2).getName()).isEqualTo("honux");
    }
}
