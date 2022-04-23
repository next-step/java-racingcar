package racingcarwinner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcarwinner.domain.Car;
import racingcarwinner.domain.ParticipatedCars;
import racingcarwinner.domain.WinnerCars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerCarsTest {

    WinnerCars winnerCars;
    ParticipatedCars participatedCars;
    String[] names = {"a", "b", "c"};

    @BeforeEach
    void setUp() {

        participatedCars = new ParticipatedCars(names);
        List<Car> cars = participatedCars.getParticipatedCars();

        cars.get(0).move(() -> true);
        cars.get(0).move(() -> true);
        cars.get(0).move(() -> true);

        cars.get(1).move(() -> true);
        cars.get(1).move(() -> true);

        cars.get(2).move(() -> true);

        winnerCars = new WinnerCars(participatedCars);
    }

    @Test
    void 참가자동차_우승자리스트() {
        assertThat(winnerCars.getWinnerCars()).hasSize(1);
    }

    @Test
    void 우승자_최대거리_같은지확인_테스트() {
        List<Car> winnerCarsList = winnerCars.getWinnerCars();
        for(Car car : winnerCarsList) {
            assertThat(car.isMaxPosition(3)).isTrue();
        }
    }

    @Test
    void 우승자이름_체크_테스트() {
        assertThat(winnerCars.getWinnerCarsName()).isEqualTo("a");

    }
}
