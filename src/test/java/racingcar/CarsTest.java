package racingcar;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @MethodSource("generateCarList")
    @ParameterizedTest
    @DisplayName("Cars 생성 테스트")
    void generateCarsTest(List<Car> cars){
        assertThatCode(() -> new Cars(cars)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Cars 생성 예외 테스트")
    void generateCarsExceptionTest(List<Car> cars){
        assertThatNullPointerException()
                .isThrownBy(() -> new Cars(cars));
    }

    @MethodSource("generateCarList")
    @ParameterizedTest
    @DisplayName("Cars moveAll 테스트")
    void moveAllTest(List<Car> cars){
        Cars racingCars = new Cars(cars);
        assertThatCode(() -> racingCars.moveAll()).doesNotThrowAnyException();
        assertThat(racingCars.moveAll()).hasSize(cars.size());
    }

    private static Stream<Arguments> generateCarList() {
        return Stream.of(
                Arguments.of(Lists.list(Car.newInstance(CarName.of("ray")))
        ));
    }
}
