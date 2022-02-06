package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    @ParameterizedTest
    @MethodSource
    void Car들_중_최대_위치_값_확인(List<Car> parameterCars) {
        final Cars cars = new Cars(parameterCars);
        assertThat(4).isEqualTo(cars.findMaxPosition().getValue());
    }

    private static Stream<Arguments> Car들_중_최대_위치_값_확인() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))));
    }

    @ParameterizedTest
    @MethodSource
    void 중복된_이름_확인(List<Car> parameterCars) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Cars(parameterCars)).withMessage("[ERROR] 중복된 이름은 들어갈 수 없습니다.");
    }

    private static Stream<Arguments> 중복된_이름_확인() {
        return Stream.of(
            Arguments.of(Arrays.asList(new Car("a", 2), new Car("a", 4), new Car("C", 1))));
    }

    @ParameterizedTest
    @MethodSource
    void 자동차_개수_확인(List<String> parameterCars) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Cars(parameterCars, 0)).withMessage("[ERROR] 자동차 개수는 적어도 1개 이상이어야 합니다.");
    }

    private static Stream<Arguments> 자동차_개수_확인() {
        return Stream.of(Arguments.of(Arrays.asList()));
    }

    @ParameterizedTest
    @MethodSource
    void Car들_전진_움직임_확인(int movableNumber, List<Car> parameterCars) {
        final Cars cars = new Cars(parameterCars);
        final List<Car> moveCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            moveCars.add(new Car(car.getNameValue(), car.getPositionValue() + 1));
        }

        final List<Car> actual = cars.driveCars(() -> movableNumber);
        for(int i = 0; i < actual.size(); i++) {
            assertThat(moveCars.get(i).getNameValue()).isEqualTo(actual.get(i).getNameValue());
            assertThat(moveCars.get(i).getPositionValue()).isEqualTo(actual.get(i).getPositionValue());
        }
    }

    private static Stream<Arguments> Car들_전진_움직임_확인() {
        return Stream.of(
            Arguments.of(4, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(5, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(6, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(7, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(8, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(9, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))));
    }

    @ParameterizedTest
    @MethodSource
    void Car들_움직이지_않는_것_확인(int notMovableNumber, List<Car> parameterCars) {
        final Cars cars = new Cars(parameterCars);
        final List<Car> actual = cars.driveCars(() -> notMovableNumber);
        for(int i = 0; i < actual.size(); i++) {
            assertThat(parameterCars.get(i).getNameValue()).isEqualTo(actual.get(i).getNameValue());
            assertThat(parameterCars.get(i).getPositionValue()).isEqualTo(actual.get(i).getPositionValue());
        }
    }
    private static Stream<Arguments> Car들_움직이지_않는_것_확인() {
        return Stream.of(
            Arguments.of(0, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(1, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(2, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))),
            Arguments.of(3, Arrays.asList(new Car("a", 2), new Car("b", 4), new Car("C", 1))));
    }
}