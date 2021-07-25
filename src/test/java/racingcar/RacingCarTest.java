package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("차 생성 테스트(3개의 차 생성)")
    @ParameterizedTest
    @CsvSource({"3"})
    void createCarsTest(int numberOfCar) {
        Cars cars = Cars.of(numberOfCar, new RandomBoundMovingStrategy());

        int actualSize = cars.getCarsCount();

        assertThat(actualSize).isEqualTo(numberOfCar);
    }

    @DisplayName("차들의 초기 위치를 제대로 가져 올 수 있는지 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void initialPositionTest(int numberOfCar, List<Integer> expectedPositions) {
        Cars cars = Cars.of(numberOfCar, new RandomBoundMovingStrategy());

        List<Integer> actualPositions = cars.getCarsPositions();

        assertThat(actualPositions).isEqualTo(expectedPositions);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(0, 0, 0))
        );
    }

    @DisplayName("차가 움직이는 조건 일 때 거리가 증가 했는지 테스트")
    @Test
    void carMoveTest() {
        Car car = new Car();
        car.setMovingStrategy(new RandomBoundMovingStrategy());
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }


    @DisplayName("차가 움직이지 않는 조건 일 때 거리가 증가 하지 않았는지 테스트")
    @Test
    void carNotMoveTest() {
        Car car = new Car();
        car.setMovingStrategy(new RandomBoundMovingStrategy());
        car.move(false);
        int position = car.getPosition();

        assertThat(position).isEqualTo(0);
    }

}
