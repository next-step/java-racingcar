package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingCar;
import racing.domain.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {
    @Test
    void 자동차리스트_생성() {
        RacingCars racingCars = new RacingCars("audi,bmw,benz");
        assertThat(racingCars.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "audi,ferrari", "audi,,bmw"})
    void 잘못된_자동차리스트_생성(String names) {
        assertThatThrownBy(() -> new RacingCars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 최대거리() {
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("audi", 2),
                new RacingCar("bmw", 3),
                new RacingCar("benz", 1)));
        assertThat(racingCars.getMaxPosition()).isEqualTo(3);
    }

    @Test
    void 단일_우승자() {
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("audi", 2),
                new RacingCar("bmw", 3),
                new RacingCar("benz", 1)));
        assertThat(racingCars.getWinnerNames()).containsExactly("bmw");
    }

    @Test
    void 여러_우승자() {
        RacingCars racingCars = new RacingCars(List.of(
                new RacingCar("audi", 3),
                new RacingCar("bmw", 3),
                new RacingCar("benz", 1)));
        assertThat(racingCars.getWinnerNames()).hasSize(2);
    }
}
