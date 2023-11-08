package step3;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Random random = new Random();

    @Test
    void assertGameSetup() {
        GameSetup newGame = new GameSetup(5,2, random);

        assertThat(newGame.cars.size()).isEqualTo(5);
        assertThat(newGame.round).isEqualTo(2);
    }

    @Test
    void assertStartGame() {
        GameSetup newGame = new GameSetup(5,3, random);
        AtomicInteger sumBeforeStartGame = new AtomicInteger();
        AtomicInteger sumAfterStartGame = new AtomicInteger();

        newGame.cars.forEach(car -> {
            sumBeforeStartGame.set(+car.getDistance());
        });

        assertThat(sumBeforeStartGame.get()).isEqualTo(0);

        for (int i = 0; i < newGame.round; i++) {
            newGame.moveCar(random);
        }
        newGame.cars.forEach(car -> {
            sumAfterStartGame.set(+car.getDistance());
        });
        assertThat(sumAfterStartGame.get()).isGreaterThan(0);
    }

    @Test
    void assertCar() {
        Car car = new Car();
        car.moveCar();

        assertThat(car.getDistance()).isEqualTo(1);
    }
}