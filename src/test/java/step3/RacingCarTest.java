package step3;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RacingCarTest {

    RacingCar rc = new RacingCar();
    int car = 3;
    int count = 5;

    @ParameterizedTest(name = "{0} : add {1}")
    @MethodSource("goParameter")
    void 이동_여부(boolean goStop, int result) {
        Car car = new Car();
        car.goOrStop(goStop);
        assertThat(car.getGoCount()).isEqualTo(result);
    }
    static Stream<Arguments> goParameter(){
        return Stream.of(
                arguments(true, 1)
                ,arguments(false, 0)
        );
    }

    @ParameterizedTest(name = "{0} is more than 4 : {1}")
    @MethodSource("parameter")
    void 특정값_이상_체크(int value, boolean result) {
        assertThat(rc.isValueMoreThan(value)).isEqualTo(result);
    }

    static Stream<Arguments> parameter(){
        return Stream.of(
                arguments(1, false)
                ,arguments(2, false)
                ,arguments(4, true)
                ,arguments(6, true)
        );
    }

    @Test
    void 차_대수만큼_리스트_사이즈() {
        Assertions.assertThat(rc.initCars(car)).hasSize(car);
    }
}
