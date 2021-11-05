package step3.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.car.Car;
import step3.domain.car.Location;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    private static final int POWER_BOUND = 4;
    private static final int LOCATION = 0;
    private static final int INTERVAL = 1;

    @DisplayName("CAR 생성 입력값 null 테스트")
    @ParameterizedTest(name = "[{index}] powerBound: {0}, location: {1}")
    @MethodSource(value = "generateCreateCarNullInputs")
    void createCarTest(Integer powerBound, Location location) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(powerBound, location))
                .withMessageContaining("is Required");
    }

    @DisplayName("go 메소드 입력 값 null 테스트")
    @Test
    void goInputTest() {
        Car car = createCar();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.go(null))
                .withMessage("power is Required");
    }

    @DisplayName("go 메소드 입력 값 범위 벗어날 떄 테스트")
    @ParameterizedTest(name = "[{index}] power: {0}")
    @CsvSource(value = {"-1", "10"})
    void goInputTest2(Integer power) {
        Car car = createCar();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.go(power))
                .withMessage("power의 범위는 0 - 9 이어야 합니다.");
    }

    @DisplayName("입력 값이 4미만이면 정지 4이상이면 전진한다.")
    @ParameterizedTest(name = "[{index}] power: {0}, expectedCar: {1}")
    @MethodSource("generateGoInputs")
    void goTest(Integer power, Car expectedCar) {
        Car car = createCar(Location.placeOn(LOCATION, INTERVAL));

        car.go(power);

        assertThat(car).isEqualTo(expectedCar);
    }

    private static Car createCar() {
        return new Car(POWER_BOUND, Location.placeOn(LOCATION));
    }

    private static Car createCar(Location location) {
        return new Car(POWER_BOUND, location);
    }

    private static Stream<Arguments> generateCreateCarNullInputs() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, Location.placeOn(LOCATION)),
                Arguments.of(POWER_BOUND, null)
        );
    }

    private static Stream<Arguments> generateGoInputs() {
        return Stream.of(
                Arguments.of(3, createCar(Location.placeOn(LOCATION, INTERVAL))),
                Arguments.of(4, createCar(Location.placeOn(LOCATION + INTERVAL, INTERVAL)))
        );
    }

}
