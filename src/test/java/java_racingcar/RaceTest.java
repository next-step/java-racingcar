package java_racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    @DisplayName("경주를 할 자동차가 주어진 숫자만큼 만들어 졌는지 확인한다")
    void readyForRacingCarTest() {
        Race race = new Race();
        List<Car> cars = race.readyForRacingCar(3);

        assertThat(cars).hasSize(3);
    }
}