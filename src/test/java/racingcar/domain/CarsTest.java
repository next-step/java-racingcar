package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("차 집합이 이동을 하였을 때, 이동 여부를 체크한다.")
    void move() {
        Cars cars = new Cars(List.of(new Car("test1", 2)));

        List<CarStat> result = cars.move(() -> true);

        assertThat(result).isEqualTo(List.of(new CarStat(new Name("test1"), new Position(3))));
    }

    @Test
    @DisplayName("차 집합이 주어졌을 때, 우승자를 구한다.")
    void findWinners() {
        Cars cars = new Cars(List.of(new Car("test1", 2), new Car("test2", 2), new Car("test3", 1)));

        cars.move(() -> true);

        List<Name> carNames = cars.findWinners().stream()
            .map(CarStat::getName)
            .collect(Collectors.toList());

        assertThat(carNames).isEqualTo(List.of(new Name("test1"), new Name("test2")));
    }
}
