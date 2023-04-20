package basicgame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars();
    }

    @DisplayName("전진 가능 여부 테스트")
    @MethodSource("isEnoughToGoTestArguments")
    @ParameterizedTest
    void isEnoughToGoTest(int value, boolean expected) {
        Car car = Car.newInstance("Ben", 1);

        boolean actual = car.isEnoughValue(value);

        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> isEnoughToGoTestArguments() {
        return Stream.of(
                Arguments.of(-5, false),
                Arguments.of(-4, false),
                Arguments.of(-3, false),
                Arguments.of(-2, false),
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true),
                Arguments.of(8, true),
                Arguments.of(9, true)
        );
    }

    @Test
    @DisplayName("Car 개수에 맞게 생성 테스트 Success")
    void initCarTestSuccess() {
        var expectedCarCount = 3;
        var carNameInput = "A,B,C".split(",");

        cars.initCar(carNameInput);

        assertThat(cars.carsSize()).isEqualTo(expectedCarCount);
    }

    @DisplayName("Car Name Size 맞게 생성 테스트 Success")
    @MethodSource("initCarWithNameTestSuccessArguments")
    @ParameterizedTest
    void initCarWithNameTestSuccess(String carName) {
        var car = Car.newInstance(carName, 1);
        assertThat(car).isNotNull();
    }

    public static Stream<Arguments> initCarWithNameTestSuccessArguments() {
        return Stream.of(
                Arguments.of("H"),
                Arguments.of("He"),
                Arguments.of("Hel"),
                Arguments.of("Hell"),
                Arguments.of("Hello")
        );
    }

    @DisplayName("Car Name Size 맞게 생성 테스트 Failure")
    @MethodSource("initCarWithNameTestFailureArguments")
    @ParameterizedTest
    void initCarWithNameTestFailure(String carName, Exception e) {
        assertThatThrownBy(() -> Car.newInstance(carName, 1))
                .isInstanceOf(e.getClass());
    }

    public static Stream<Arguments> initCarWithNameTestFailureArguments() {
        return Stream.of(
                Arguments.of("", new NullPointerException()),
                Arguments.of(null, new NullPointerException()),
                Arguments.of("Hellow", new IllegalArgumentException())
        );
    }

    @Test
    @DisplayName("Car 가져오는지와 체크 테스트 Success")
    void getCarsTestSuccess() {
        var expectedCarCount = 3;
        var carNameInput = "A,B,C".split(",");

        cars.initCar(carNameInput);
        var actualList = cars.getCars();

        assertThat(actualList.size()).isEqualTo(expectedCarCount);
    }

    @Test
    @DisplayName("Car getWinner 테스트 Success")
    void getWinnerTestSuccess() {

        var carTryCount = 5;
        var carNameInput = "pobi,crong,honux".split(",");

        var expectedWinnerName1 = "win1";
        var expectedWinnerName2 = "win2";

        cars.initCar(carNameInput);
        cars.addCar(expectedWinnerName1, 10);
        cars.addCar(expectedWinnerName2, 10);

        for ( int i=0; i< carTryCount; i++) {
            cars.activeCar(0);
        }

        var actualWinnerList = cars.getWinner();

        assertThat(actualWinnerList.stream()
                .map(Car::getName))
                .isEqualTo(List.of(expectedWinnerName1, expectedWinnerName2));
    }
}