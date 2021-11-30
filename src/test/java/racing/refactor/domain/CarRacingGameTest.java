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
        CarRacingGame carRacingGame = new CarRacingGame(CarRacingGame.instanceOfCarNames(cars));
        List<Car> expectedCars = Arrays.asList(
                 new Car("A", 1)
                ,new Car("B", 1)
                ,new Car("C", 1)
        );
        carRacingGame.moveCars(MOVE);
        assertEquals(expectedCars, carRacingGame.getCars());
    }

    @Test
    @DisplayName("모두 정지")
    public void allStop() {
        List<String> cars = Arrays.asList("A","B","C");
        CarRacingGame carRacingGame = new CarRacingGame(CarRacingGame.instanceOfCarNames(cars));
        List<Car> expectedCars = Arrays.asList(
                 new Car("A", 0)
                ,new Car("B", 0)
                ,new Car("C", 0)
        );
        carRacingGame.moveCars(STOP);
        assertEquals(expectedCars, carRacingGame.getCars());
    }

    @Test
    @DisplayName("최고 위치 값이 5일 때 5 리턴")
    public void topPosition() {
        List<Car> cars = Arrays.asList(
                 new Car("tony", 3)
                ,new Car("van", 2)
                ,new Car("poyal", 5)
        );
        CarRacingGame carRacingGame = new CarRacingGame(cars);
        Position expectedPosition = new Position(5);

        assertEquals(expectedPosition, carRacingGame.topPosition());
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
        List<Car> expectedCars = Arrays.asList(
                 new Car("A", 5)
                ,new Car("C", 5)
        );
        assertEquals(expectedCars, carRacingGame.getWinners());
    }
}