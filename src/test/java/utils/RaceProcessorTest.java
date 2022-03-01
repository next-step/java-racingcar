package utils;

import core.Car;
import core.Cars;
import core.TestObjectGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RaceProcessorTest {
    @Test
    @DisplayName("moveCount * 자동차 수 만큼 이동명령이 실행돼야 한다")
    void moveCarsRandomly() {
        //given
        Car mockedCar = mock(Car.class);
        final int carCount = 3;
        Cars cars = TestObjectGenerator.generateCars(mockedCar, carCount);
        final int moveCount = 5;

        //when
        RaceProcessor.moveCarsRandomly(cars, moveCount);

        //then
        verify(mockedCar, times(moveCount * carCount)).move(anyInt());
    }
}