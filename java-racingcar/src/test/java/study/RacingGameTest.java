package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.function.Supplier;

class RacingGameTest {
    private RacingGame racingGame;
    private static final int TEST_CARS = 3;
    private static final int TEST_ROUNDS = 5;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TEST_CARS, TEST_ROUNDS);
    }

    @Test
    void testCarCreation() {
        assertNotNull(racingGame);
    }

    @Test
    void testRaceProgression() {
        racingGame.start();
        List<Car> cars = racingGame.getCars();

        assertEquals(TEST_CARS, cars.size());
        for (Car car : cars) {
            assertNotNull(car.getPosition());
        }
    }

    @Test
    void testCarMovesOrStays() {
        Car car = new Car(() -> 5); // ✅ 항상 5를 반환하는 Supplier
        String initialPosition = car.getPosition();
        car.move();
        String newPosition = car.getPosition();
        assertTrue(newPosition.equals(initialPosition) || newPosition.length() > initialPosition.length());
    }

    @Test
    void 자동차는_4이상일_때_이동한다() {
        Car car = new Car(() -> 5); // ✅ 항상 5를 반환하는 Supplier (이동)
        car.move();
        assertThat(car.getPosition()).isEqualTo("-"); // ✅ "-"로 이동해야 함
    }

    @Test
    void 자동차는_3이하일_때_멈춘다() {
        Car car = new Car(() -> 3); // ✅ 항상 3을 반환하는 Supplier (멈춤)
        car.move();
        assertThat(car.getPosition()).isEqualTo(""); // ✅ 이동하지 않음
    }
}