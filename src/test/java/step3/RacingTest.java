package step3;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Random random = new Random();

    @Test
    void assertGameSetup() {
        Racing newGame = new Racing();
        newGame.setupGame(5,2, random);

        assertThat(newGame.cars.size()).isEqualTo(5);
        assertThat(newGame.round).isEqualTo(2);
    }

    @Test
    void assertStartGame() {
        Racing newGame = new Racing();
        newGame.setupGame(5,2, random);
        AtomicInteger sumBeforeStartGame = new AtomicInteger();
        AtomicInteger sumAfterStartGame = new AtomicInteger();

        newGame.cars.forEach(car -> {
            sumBeforeStartGame.set(+car.index);
        });

        assertThat(sumBeforeStartGame.get()).isEqualTo(0);

        newGame.startGame();
        newGame.cars.forEach(car -> {
            sumAfterStartGame.addAndGet(1);
        });
        assertThat(sumAfterStartGame.get()).isGreaterThan(0);
    }
}