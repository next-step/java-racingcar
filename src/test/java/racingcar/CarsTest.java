package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("차 리스트를 가져오는지 확인")
    void getCars() {
        String[] carNames = {"truck", "cycle", "pobi"};
        Cars cars = new Cars(carNames);

        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).extracting("name").containsExactly("truck", "cycle", "pobi");
    }

    @Test
    @DisplayName("최대 거리를 가져오는지 확인")
    void getMaxDistance() {
        String[] carNames = {"truck", "cycle", "pobi"};
        Cars cars = new Cars(carNames);
        cars.getCars().get(0).move(true);
        cars.getCars().get(1).move(false);
        cars.getCars().get(2).move(true);

        assertThat(cars.getMaxDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자를 가져오는지 확인")
    void getWinners() {
        String[] carNames = {"truck", "cycle", "pobi"};
        Cars cars = new Cars(carNames);
        cars.getCars().get(0).move(true);
        cars.getCars().get(1).move(false);
        cars.getCars().get(2).move(true);

        assertThat(cars.getWinners()).extracting("name").containsExactly("truck", "pobi");
    }
}
