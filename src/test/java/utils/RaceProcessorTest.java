package utils;

import core.Car;
import core.Cars;
import core.TestObjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceProcessorTest {
    @Test
    @DisplayName("cars 의 모든 Car 가 moveCount 번 움직여야 한다")
    void moveCarsRandomlyMoveCountTimes() {
        //given
        final int initialPosition = 5;
        Car car = TestObjectGenerator.generateCar("a", initialPosition);
        Cars cars = TestObjectGenerator.generateCars(car, 3);
        final int moveCount = 3;
        NumberGenerator moveNumberGenerator = TestObjectGenerator.generateMoveNumberGenerator();

        //when
        Cars result = RaceProcessor.moveCarsRandomlyMoveCountTimes(cars, moveCount, moveNumberGenerator);

        //then
        result.getCars().forEach(movedCar -> assertThat(movedCar.getPosition()).isEqualTo(initialPosition + moveCount));
    }
}