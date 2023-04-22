package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CarTest {

    Car car = new Car();
    int carCount = 3;

    @Test
    void 차_대수만큼_리스트_사이즈() {
        Assertions.assertThat(car.createCars(carCount)).hasSize(carCount);
    }

    @ParameterizedTest(name = "{0} : add {1}")
    @MethodSource("goParameter")
    void 이동_여부(boolean goStop, int result) {
        car.addGoCount();
        assertThat(car.getGoCount()).isEqualTo(result);
    }
    static Stream<Arguments> goParameter(){
        return Stream.of(
                arguments(true, 1)
                ,arguments(false, 0)
        );
    }
}
