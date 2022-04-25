package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("cars 의 모든 Car 가 moveCount 번 움직여야 한다")
    void moveCarsRandomlyMoveCountTimes() {
        //given
        final int moveCount = 3;
        Car car = TestObjectGenerator.generateCar("a", 0);
        Cars cars = TestObjectGenerator.generateCars(car, 3);
        RacingGame racingGame = TestObjectGenerator.generateRacingGame();

        //when
        Cars result = racingGame.play(cars, 3);

        //then
        result.getCars().forEach(movedCar -> assertThat(movedCar.getPosition()).isEqualTo(moveCount));
    }
}