package step3.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import step3.strategy.RandomMoveStrategy;

class CarsTest {

    @Test
    void 자동차들_객체_생성() {
        String carNames = "hwan,hwan2,hwan3";
        Cars cars = Cars.from(carNames);

        assertThat(cars.getCars()).hasSize(3);
    }

    @Test
    void 자동차들_전진_확인() {
        String carNames = "hwan,hwan2,hwan3";
        Cars cars = Cars.from(carNames);

        RandomMoveStrategy randomStrategy = new RandomMoveStrategy();
        for (int i = 0; i < 100; i++) {
            cars.moveCars(randomStrategy);
        }

        List<Integer> movements = cars.getCars().stream()
                .map(Car::getMovement)
                .collect(Collectors.toList());

        assertThat(movements).anyMatch(movement -> movement > 0);
    }

    @Test
    void 우승자_생성_확인() {
        Car hwan2 = new Car("hwan2", new Movement(3));
        Car chan = new Car("chan", new Movement());
        Car ming = new Car("ming", new Movement(2));

        Cars cars = new Cars(Arrays.asList(hwan2, chan, ming));
        RaceWinners raceWinners = cars.getRaceWinners();

        assertThat(raceWinners.getWinnerNames()).hasSize(1);
        assertThat(raceWinners.getWinnerNames()).contains("hwan2");
    }
}
