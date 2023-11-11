package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @Test
    void 자동차_생성_이름부여() {

        RaceInfo raceInfo = new RaceInfo(new String[]{"test1", "test2", "test3"}, 5);
        Racing racing = new Racing();
        List<Car> cars = racing.generateNamedCar(raceInfo);

        assertThat(cars.get(0).carName()).isEqualTo("test1");
        assertThat(cars.get(1).carName()).isEqualTo("test2");
        assertThat(cars.get(2).carName()).isEqualTo("test3");
    }

    @Test
    void 우승자_선정() {

        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        test1.move(() -> true);
        test2.move(() -> false);

        List<Car> cars = new ArrayList<>();
        cars.add(test1);
        cars.add(test2);

        List<String> winner = new Racing().winner(cars);
        assertThat(winner.get(0)).isEqualTo("test1");
    }
}