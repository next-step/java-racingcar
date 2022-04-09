package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RaceModelTest {

    @Test
    @DisplayName("cars 의 모든 Car 가 moveCount 번 움직여야 한다")
    void moveCarsRandomlyMoveCountTimes() {
        //given
        final int initialPosition = 5;
        Car car = TestObjectGenerator.generateCar("a", initialPosition);
        Cars cars = TestObjectGenerator.generateCars(car, 3);
        final int moveCount = 3;
        NumberGenerator moveNumberGenerator = TestObjectGenerator.generateMoveNumberGenerator();
        RaceModel raceModel = TestObjectGenerator.generateRaceModel(cars, moveCount);

        //when
        raceModel.moveCarsRandomlyMoveCountTimes(moveNumberGenerator);

        //then
        raceModel.getCars().getCars().forEach(movedCar -> assertThat(movedCar.getPosition()).isEqualTo(initialPosition + moveCount));
    }
}