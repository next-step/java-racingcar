package step4.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Cars;
import step4.domain.judge.Judge;
import step4.domain.judge.LongPositionJudge;
import step4.domain.strategy.MovingStrategy;
import step4.domain.strategy.RandomMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static step4.domain.CarFactory.produceCars;

class CarsTest {
    private static final String CARS_NAME = "pobi,jack,honux";

    private Cars cars;
    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new LongPositionJudge();
        cars = new Cars(produceCars(CARS_NAME));
    }

    @Test
    @DisplayName("모든 자동차들이 전진 조건에 만족하면 1씩 움직이는 기능 테스트")
    public void moveCars() {
        cars.moveCars(()->true);
        cars.getCars().stream().forEach(car ->
                assertEquals(car.getPosition(), 1)
        );
    }

    @Test
    @DisplayName("모든 자동차들이 전진 조건에 만족하지 않으면 정지하는 기능 테스트")
    public void stopCars() {
        cars.moveCars(()->false);
        cars.getCars().stream().forEach(car ->
                assertEquals(car.getPosition(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("generateCars")
    @DisplayName("우승한 자동차를 찾는 기능 테스트")
    void judge(String[] carNames, int[] distance, String expected) {
        Cars cars = new Cars(getCars(carNames, distance));
        assertEquals(cars.winnerCars(judge), expected);
    }

    private List<Car> getCars(String[] carNames, int[] distance) {
        List<Car> cars = new ArrayList<>();
        for (int i=0; i< carNames.length; i++) {
            Car car = new Car(carNames[i]);
            for (int j=0; j<distance[i]; j++) {
                car.move(()->true);
            }
            cars.add(car);
        }
        return cars;
    }

    static Stream<Arguments> generateCars() {
        return Stream.of(
                Arguments.arguments(CARS_NAME.split(","), new int[]{1,3,5}, "honux"),
                Arguments.arguments(CARS_NAME.split(","), new int[]{1,5,5}, "jack, honux"),
                Arguments.arguments(CARS_NAME.split(","), new int[]{7,7,7}, "pobi, jack, honux")
        );
    }
}