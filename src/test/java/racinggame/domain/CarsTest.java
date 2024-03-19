package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("pobi", "juni", "bum");
    }

    @Test
    void 자동차_리스트_생성_테스트() {
        Cars cars = Cars.from(carNames);
        assertEquals(cars.getCars().size(), carNames.size());
    }

    @Test
    void 최대_위치값_구하기_테스트() {
        Cars cars = Cars.from(carNames);
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(0).move(() -> true);
        cars.getCars().get(1).move(() -> true);

        Position maxPosition = cars.maxPosition();
        Position moved = Position.create().move().move();

        assertEquals(maxPosition, moved);
    }

    @Test
    void 우승자_이름_가져오기_테스트() {
        Cars cars = Cars.from(carNames);
        Car firstCar = cars.getCars().get(0);
        firstCar.move(() -> true);
        firstCar.move(() -> true);
        cars.getCars().get(1).move(() -> true);

        List<Name> winnerNames = cars.getWinnerNames(cars.maxPosition());

        assertEquals(winnerNames.get(0), firstCar.getName());
    }
}