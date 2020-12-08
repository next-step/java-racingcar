package step3.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;
import step3.domain.strategy.MovingStrategy;
import step3.domain.strategy.RandomMovingStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarsTest {

    private static final int NUMBER_OF_CAR = 3;

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(NUMBER_OF_CAR);
    }

    @Test
    @DisplayName("모든 자동차들이 전진 조건에 만족하면 1씩 움직이는 기능 테스트")
    public void moveCars() {
        cars.moveCars(()->true);
        cars.getCars().stream().forEach(car ->
                assertEquals(car.getPosition(), 1)
        );
    }

    @Test
    @DisplayName("모든 자동차들이 전진 조건에 만족하지 않으면 정지하는 기능 테스트")
    public void stopCars() {
        cars.moveCars(()->false);
        cars.getCars().stream().forEach(car ->
                assertEquals(car.getPosition(), 0)
        );

    }
}