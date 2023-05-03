package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Race;
import racingcar.domain.car.Car;
import racingcar.view.input.request.CarRequest;

import java.util.stream.Collectors;

class RaceTest {

    @DisplayName("raceCount가 음수인 경우 RuntimeException")
    @Test
    void test1(){
        int raceCount = -1;
        CarRequest carRequest = new CarRequest("");

        Assertions.assertThatThrownBy(() -> Race.from(raceCount, carRequest.toResource().getCars().stream().map(Car::from).collect(Collectors.toList())))
                .isInstanceOf(RuntimeException.class);
    }
}