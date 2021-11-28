package racing.refactor.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("자동차 게임 도메인 테스트(자동차 A, B, C)")
class CarRacingGameTest {

    private final MovingStrategy MOVE = () -> true;
    private final MovingStrategy STOP = () -> false;

    @Test
    @DisplayName("모두 전진")
    public void allMove() {
        List<String> cars = Arrays.asList("A","B","C");
        CarRacingGame carRacingGame = new CarRacingGame(Cars.newInstance(cars));
        List<Car> expectedTempCars = Arrays.asList(
                 new Car("A", 1)
                ,new Car("B", 1)
                ,new Car("C", 1)
        );
        Cars expectedCars = new Cars(expectedTempCars);
        assertEquals(expectedCars, carRacingGame.nextRound(MOVE));
    }

    @Test
    @DisplayName("모두 정지")
    public void allStop() {
        List<String> cars = Arrays.asList("A","B","C");
        CarRacingGame carRacingGame = new CarRacingGame(Cars.newInstance(cars));
        List<Car> expectedTempCars = Arrays.asList(
                 new Car("A", 0)
                ,new Car("B", 0)
                ,new Car("C", 0)
        );
        Cars expectedCars = new Cars(expectedTempCars);
        assertEquals(expectedCars, carRacingGame.nextRound(STOP));
    }

    @Test
    @DisplayName("우승자 추출")
    public void winners() {
        List<Car> cars = Arrays.asList(
                 new Car("A", 5)
                ,new Car("B", 3)
                ,new Car("C", 5)
        );
        CarRacingGame carRacingGame = new CarRacingGame(cars);
        List<Car> expectedTempCars = Arrays.asList(
                 new Car("A", 5)
                ,new Car("C", 5)
        );
        Cars expectedCars = new Cars(expectedTempCars);
        assertEquals(expectedCars, carRacingGame.getWinners());
    }
}