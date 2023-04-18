package basicgame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        var car = new Car(carName);
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
        assertThatThrownBy(() -> new Car(carName))
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
}