package racing.domain.game.vo.turn;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.Cars;
import racing.domain.car.entity.CarsTest;

import static org.assertj.core.api.Assertions.assertThat;


class TurnTest {
    private static CarsTest carsTest;

    @BeforeAll
    public static void setUp() {
        carsTest = new CarsTest();
    }

    @DisplayName("Turn ctor Test")
    @Test
    public void ctorTest() {
        assertThat(new Turn().isWaiting())
                .isTrue();
    }

    @DisplayName("Turn Finish Test")
    @Test
    public void finishTest() {
        Turn turn = new Turn();
        Cars cars = carsTest.initCars("AA|AAA", BasicCar::new);
        turn.finish(cars);
        assertThat(turn.isWaiting())
                .isFalse();
    }
}