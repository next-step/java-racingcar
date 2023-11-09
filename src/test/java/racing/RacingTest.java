package racing;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void assertGameSetup() {
        GameSetup newGame = new GameSetup(5,2);

        assertThat(newGame.cars.size()).isEqualTo(5);
        assertThat(newGame.round).isEqualTo(2);
    }

    @Test
    void assertStartGame() {
        GameSetup newGame = new GameSetup(5,3);
        AtomicInteger sumBeforeStartGame = new AtomicInteger();
        AtomicInteger sumAfterStartGame = new AtomicInteger();

        newGame.cars.forEach(car -> {
            sumBeforeStartGame.set(+car.getDistance());
        });

        assertThat(sumBeforeStartGame.get()).isEqualTo(0);

        for (int i = 0; i < newGame.round; i++) {
            newGame.moveCar();
        }
        newGame.cars.forEach(car -> {
            sumAfterStartGame.set(+car.getDistance());
        });
        assertThat(sumAfterStartGame.get()).isGreaterThan(0);
    }

    @Test
    void assertCar() {
        Car car = new Car();
        int testValueLessThanFour = 3;
        int testValueGreaterThanFour = 5;

        car.moveCar();

        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(testValueLessThanFour);
        assertThat(car.getDistance()).isEqualTo(1);

        car.validateForMove(testValueGreaterThanFour);
        assertThat(car.getDistance()).isEqualTo(2);
    }
}