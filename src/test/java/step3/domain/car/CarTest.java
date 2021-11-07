package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    private static final int LOCATION = 0;
    private static final int INTERVAL = 1;

    @Test
    @DisplayName("CAR 생성 입력값 null 테스트")
    void createCarTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(null))
                .withMessageContaining("location is Required");
    }

    @DisplayName("go 메소드 입력 값 null 테스트")
    @Test
    void goInputTest() {
        Car car = new Car(Location.placeOn(LOCATION));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.go(null))
                .withMessage("power is Required");
    }

    @DisplayName("go 메소드 입력 값 범위 벗어날 떄 테스트")
    @ParameterizedTest(name = "[{index}] power: {0}")
    @CsvSource(value = {"-1", "10"})
    void goInputTest2(Integer power) {
        Car car = new Car(Location.placeOn(LOCATION));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> car.go(power))
                .withMessage("power의 범위는 0 - 9 이어야 합니다.");
    }

    @DisplayName("입력 값이 4미만이면 정지 4이상이면 전진한다.")
    @ParameterizedTest(name = "[{index}] power: {0}, expectedCar: {1}")
    @MethodSource("generateGoInputs")
    void goTest(Integer power, Car expectedCar) {
        Car car = new Car(Location.placeOn(LOCATION, INTERVAL));

        car.go(power);

        assertThat(car).isEqualTo(expectedCar);
    }

    private static Stream<Arguments> generateGoInputs() {
        return Stream.of(
                Arguments.of(3, new Car(Location.placeOn(LOCATION, INTERVAL))),
                Arguments.of(4, new Car(Location.placeOn(LOCATION + INTERVAL, INTERVAL)))
        );
    }

}
