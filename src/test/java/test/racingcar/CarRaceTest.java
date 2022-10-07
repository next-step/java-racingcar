package test.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarRace;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

    @Test
    @DisplayName("레이싱 게임 후 결과 size 확인")
    void race_test() {
        List<Car> cars = new CarRace().race(5, 3);
        assertThat(cars).hasSize(5);
    }
}
