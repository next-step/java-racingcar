package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @Test
    @DisplayName("자동차 경주 게임을 한번 실행했을 때, 자동차가 한 번 전진한다.")
    void runOnce() {
        Car carLuna = new Car("luna", 0);
        List<Car> cars = List.of(carLuna);
        NumberGenerator numberGenerator = () -> 4;

        CarRace carRace = new CarRace(cars, 2, numberGenerator);
        carRace.run();

        assertThat(carLuna).isEqualTo(new Car("luna", 2));
    }

}
