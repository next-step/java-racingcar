package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingCarsException;

public class RacingCarsTest {
    List<RacingCar> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        cars.add(new RacingCar("차1"));
        cars.add(new RacingCar("차2"));
        cars.add(new RacingCar("차3"));
    }

    @Test
    void 이동_테스트() {
        RacingCars racingCars = new RacingCars(cars);

        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(0);
        randomNumbers.add(0);
        randomNumbers.add(10);

        racingCars.moveCars(new RandomNumbers(randomNumbers));

        List<RacingCar> r = new ArrayList<>();
        r.add(new RacingCar("차1"));
        r.add(new RacingCar("차2"));
        r.add(new RacingCar("차3", 1));

        assertThat(racingCars).isEqualTo(new RacingCars(r));
    }

    @Test
    void 최대포지션_테스트() {
        RacingCars racingCars = new RacingCars(cars);

        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(0);
        randomNumbers.add(0);
        randomNumbers.add(10);

        racingCars.moveCars(new RandomNumbers(randomNumbers));

        assertThat(racingCars.maxPosition()).isEqualTo(1);
    }

    @Test
    void 최대포지션_차_테스트() {
        RacingCars racingCars = new RacingCars(cars);

        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(0);
        randomNumbers.add(0);
        randomNumbers.add(10);

        racingCars.moveCars(new RandomNumbers(randomNumbers));

        List<RacingCar> winners = new ArrayList<>();
        winners.add(new RacingCar("차3", 1));

        assertThat(racingCars.maxPositionCar(1)).isEqualTo(winners);
    }

    @Test
    void 빈_자동차리스트_테스트() {
        assertThatThrownBy(() -> {
            RacingCars racingCars = new RacingCars(null);
        }).isInstanceOf(RacingCarsException.class)
                .hasMessageMatching("자동차는 한 개 이상 입력해야 합니다");
    }
}
