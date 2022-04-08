package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

class RacingCarGameTest {

    private static final Random random = new Random();
    private static final int STOP_LOW = 0;
    private static final int STOP_HIGH = 3;
    private static final int MOVE_LOW = 4;
    private static final int MOVE_HIGH = 9;
    private final int carCount = 10;
    private final int rounds = 10;
    private List<Car> cars;
    private RacingCarGame game;

    @BeforeEach
    void setUp() {
        cars = CarFactory.generateCarsOfSize(carCount);
        game = new RacingCarGame(cars, rounds);
    }

    @Test
    void rounds_만큼_proceedRound_호출하면_정상동작() {

        assertThatNoException().isThrownBy(() -> {
            for (int i = 0; i < rounds; i++) {
                game.proceedRound(RandomGenerator.generateRandomsOfSize(carCount));
            }
        });
    }

    @Test
    void rounds_보다_proceedRound_많이_호출하면_예외() {

        assertThatThrownBy(() -> {
            for (int i = 0; i < rounds + 1; i++) {
                game.proceedRound(RandomGenerator.generateRandomsOfSize(carCount));
            }
        }).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("proceedRound() 호출 시 자동차에 제공된 값이 0 ~ 3이면 정지")
    @Test
    void proceedRound_정지() {
        List<Integer> stopNumbers = getStopNumbers();

        game.proceedRound(stopNumbers);

        cars.forEach(car -> {
            assertThat(car.position()).isZero();
        });
    }

    @DisplayName("proceedRound() 호출 시 자동차에 제공된 값이 4 ~ 9이면 이동")
    @Test
    void proceedRound_이동() {
        List<Integer> moveNumbers = getMoveNumbers();

        game.proceedRound(moveNumbers);

        cars.forEach(car -> {
            assertThat(car.position()).isOne();
        });
    }

    private List<Integer> getStopNumbers() {
        List<Integer> stopNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            stopNumbers.add(getStopNumber());
        }
        return stopNumbers;
    }

    private List<Integer> getMoveNumbers() {
        List<Integer> moveNumbers = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            moveNumbers.add(getMoveNumber());
        }
        return moveNumbers;
    }

    private int getStopNumber() {
        return generateRandomBetween(STOP_LOW, STOP_HIGH);
    }

    private int getMoveNumber() {
        return generateRandomBetween(MOVE_LOW, MOVE_HIGH);
    }

    private int generateRandomBetween(int low, int high) {
        return random.nextInt(high - low + 1) + low;
    }
}