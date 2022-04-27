package study.step4.try1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    @Test
    @DisplayName("자동차 경주를 시작한다.")
    void 자동차_경주를_시작() {
        Cars cars = new Cars("pobi,crong,honux");
        int numberOfAttempts = 5;
        CarRacingGame carRacingGame = new CarRacingGame(cars, numberOfAttempts);
        assertThat(carRacingGame.start().size()-numberOfAttempts).isEqualTo(cars.getCars().size()*numberOfAttempts);
    }
}
