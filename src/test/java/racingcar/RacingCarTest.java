package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RaceInfo;
import racingcar.util.RandomNumberUtils;
import racingcar.view.InputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RaceInfo raceInfo;

    List<Car> racingCars;

    Cars cars;

    void given(int numberOfCar, int raceTrialCount) {
        raceInfo = new RaceInfo(numberOfCar, raceTrialCount);

        racingCars = new ArrayList<Car>();

        for (int i = 0; i < raceInfo.numberOfCar; i++) {
            racingCars.add(new Car());
        }
        cars = new Cars(racingCars);
    }

    @DisplayName("차 생성 테스트(3개의 차 생성)")
    @ParameterizedTest
    @CsvSource({"3 , 5"})
    void createCarsTest(int numberOfCar, int raceTrialCount) {
        given(numberOfCar, raceTrialCount);

        int actualSize = cars.getCarsCount();

        assertThat(actualSize).isEqualTo(numberOfCar);
    }

    @DisplayName("차들의 초기 위치를 제대로 가져 올 수 있는지 테스트")
    @ParameterizedTest
    @MethodSource("generateData")
    void initialPositionTest(int numberOfCar, int raceTrialCount, List<Integer> expected) {
        given(numberOfCar, raceTrialCount);

        List<Integer> actual = cars.getCarsPositions();

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(3, 5, Arrays.asList(0, 0, 0))
        );
    }

    @DisplayName("4~9 숫자가 발생 했을 때 차가 움직이는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveCarRangeIsCorrectTest(int actualNumber) {
        Car car = new Car();
        car.movable(actualNumber);

        int position = car.getPosition();

        assertThat(position).isEqualTo(1);
    }


    @DisplayName("1~3 숫자가 발생 했을 때 차가 움직이지 않는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void moveCarRangeIsInCorrectTest(int actualNumber) {
        Car car = new Car();
        car.movable(actualNumber);

        int position = car.getPosition();

        assertThat(position).isEqualTo(0);
    }

}
