package step5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


class CarRacingTest {

    private CarRacing carRacing;
    private String[] carNames;

    @BeforeEach
    void init() {
        carNames = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff","ggg"};
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
        carRacing.moveProgress(new Go());

        Cars currentStatus = carRacing.getCurrentStatus();
        Car currentCar = currentStatus.getCars().get(0);
        int position = currentCar.getPosition().getPosition();

        int expected = 2;

        assertEquals(position, expected);
    }

    @DisplayName("getMove 테스트 - 정지일 경우")
    @Test
    void getStopTest() {
        carRacing.moveProgress(new Stop());

        Cars currentStatus = carRacing.getCurrentStatus();
        Car currentCar = currentStatus.getCars().get(0);
        int position = currentCar.getPosition().getPosition();

        int expected = 1;

        assertEquals(position, expected);
    }

    @DisplayName("winner 테스트 - 두명이상일 경우")
    @Test
    void winnersTest() {

        List<Car> winners =
                Arrays.asList(
                        new Car("aaa", 5),
                        new Car("ccc", 5),
                        new Car("ggg", 5));

        carRacing = new CarRacing(carNames);

        IntStream.range(0, 4).forEach(i -> carRacing.moveProgress(new RandomMove()));
        WinnersResponse winnersResponse = carRacing.getWinner();

        assertTrue(winnersResponse.getWinners().containsAll(winners));
    }

    @DisplayName("winner 테스트 - 한명일 경우")
    @Test
    void winnerTest() {
        Car car = new Car("aaa", 2);
        carRacing.moveProgress(new RandomMove());
        WinnersResponse winnersResponse = carRacing.getWinner();

        Car winnersCar = winnersResponse.getWinners().get(0);

        assertEquals(winnersCar, car);
    }
}