package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingCarWinnerTest {
    RacingCar car;
    List<RacingCar> cars;
    @BeforeEach
    void init() throws IllegalAccessException {
        car = new RacingCar(3,"car");
        cars = getCars();
    }
    @Test
    void 자동차이름_5자_초과되지않음() throws Exception {
        assertThatThrownBy(() -> new RacingCar(3, "abcdefg")).isInstanceOf(IllegalAccessException.class);
    }
    @Test
    void 자동차는_이름_전진횟수를_가진다() throws Exception {
        assertThat(car.getProgress()).isNotZero();
        assertThat(car.getName()).isNotNull();
    }
    @ParameterizedTest
    @CsvSource("3")
    void 가장_많은_전진횟수_우승_1명이상() throws Exception {
        // when
        List<RacingCar> winners = Simulator.getWinners(cars);
        // then
        assertThat(winners.stream().anyMatch(car -> "a".equals(car.getName()))).isTrue();
        assertThat(winners.stream().anyMatch(car -> "b".equals(car.getName()))).isTrue();
    }

    private List<RacingCar> getCars() throws IllegalAccessException {
        List<RacingCar> cars = new ArrayList<>();
        RacingCar carA = new RacingCar(3, "a");
        RacingCar carB = new RacingCar(3, "b");
        RacingCar carC = new RacingCar(2, "c");
        cars.add(carA);
        cars.add(carB);
        cars.add(carC);
        return cars;
    }

}
