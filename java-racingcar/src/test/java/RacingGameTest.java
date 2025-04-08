import domain.Car;
import domain.RacingGame;
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

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("Car1", "Car2", "Car3");
        int rounds = 3;
        Supplier<Integer> fixedRandomSupplier = () -> 5; // 항상 5를 반환하도록 설정
        racingGame = new RacingGame(carNames, rounds, fixedRandomSupplier);
    }

    @Test
    void 라운드가_음수이면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame(List.of("Car1"), -1, () -> 5));
    }

    @Test
    void 라운드가_0이면_예외발생() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame(List.of("Car1"), 0, () -> 5));
    }

    @Test
    void 자동차_이름으로_자동차_객체가_잘_생성되는지() {
        List<Car> cars = racingGame.getCars();
        assertEquals(3, cars.size());
        assertEquals("Car1", cars.get(0).getName());
        assertEquals("Car2", cars.get(1).getName());
        assertEquals("Car3", cars.get(2).getName());
    }

    @Test
    void 우승자_확인_테스트() {
        racingGame.start(); // 모든 자동차가 3번 이동
        String winner = racingGame.checkWinnerCar(racingGame.getCars());
        assertEquals("Car1", winner); // 모든 차가 같은 거리 이동
    }

}