package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRacingPlayTest {

    private CarRacingPlay carRacingPlay;

    @Test
    @DisplayName("randomValue 가 0 ~ 3 사이의 숫자가 나오면 이동하지 않습니다.")
    void invalidRandomValue() {
        // given
        carRacingPlay = new CarRacingPlay(new TestNotGoRandomValueGenerator(), 1);
        // when
        List<Car> cars = carRacingPlay.raceOneCycle();
        // then
        assertThat(cars.get(0).getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("randomValue 가 4 ~ 9 사이의 숫자가 나오면 이동합니다.")
    void validRandomValue() {
        // given
        carRacingPlay = new CarRacingPlay(new TestValidRandomValueGenerator(), 1);
        // when
        List<Car> cars = carRacingPlay.raceOneCycle();
        // then
        assertThat(cars.get(0).getDistance()).isEqualTo(1);
    }
}