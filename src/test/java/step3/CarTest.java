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

    RacingCar rc = new RacingCar();
    Car car = new Car();
    int carCount = 3;

    @Test
    void 차_대수만큼_리스트_사이즈() {
        Assertions.assertThat(rc.createCars(carCount)).hasSize(carCount);
    }

}
