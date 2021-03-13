package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CarRacingTest {

    private CarRacing carRacing;
    private String[] carNames;

    @BeforeEach
    void init() {
        carNames = new String[]{"aaa", "bbb"};
        carRacing = new CarRacing(carNames);
    }

    @DisplayName("getCurrentStatus 테스트")
    @Test
    void getReadyTest() {
        List<Car> cars =
                Arrays.asList(new Car("aaa", 1), new Car("bbb", 1));
        Cars currentStatus = carRacing.getCurrentStatus();

        assertTrue(currentStatus.getCars().containsAll(cars));
    }

    @DisplayName("getMove 테스트 - 이동일 경우")
    @Test
    void getMoveTest() {
        List<Car> cars =
                Arrays.asList(new Car("aaa", 2), new Car("bbb", 2));
        carRacing.moveProgress(new Go());
        Cars currentStatus = carRacing.getCurrentStatus();

        System.out.println("currentStatus.getCars().get(0) = " + currentStatus.getCars().get(0));
        System.out.println("cars.get(0) = " + cars.get(0));

        assertTrue(currentStatus.getCars().get(0).equals(cars.get(0)));
    }

    @DisplayName("getMove 테스트 - 정지일 경우")
    @Test
    void getStopTest() {
        List<Car> cars =
                Arrays.asList(new Car("aaa", 2), new Car("bbb", 2));
        carRacing.moveProgress(new Stop());
        Cars currentStatus = carRacing.getCurrentStatus();

        assertFalse(currentStatus.getCars().get(0).equals(cars.get(0)));
    }

    @DisplayName("winner 테스트 - 두명이상일 경우")
    @Test
    void winnersTest() {
        Winners winners = carRacing.getWinner();
        List<Car> cars =
                Arrays.asList(new Car("aaa", 1), new Car("bbb", 1));

        assertTrue(winners.getWinners().containsAll(cars));
    }

    @DisplayName("winner 테스트 - 한명일 경우")
    @Test
    void winnerTest() {
        Car car = new Car("aaa", 2);
        carRacing.moveProgress(new RandomMove());
        Winners winner = carRacing.getWinner();

        assertTrue(winner.getWinners().get(0).equals(car));
    }
}