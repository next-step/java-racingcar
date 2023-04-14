package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @DisplayName("winner 를 생성한다.")
    @Test
    void test01() {
        Winner winner = new Winner(getCars(
                getCar("name1", 1), getCar("name2", 2))
        );

        assertThat(winner).isNotNull();
    }

    @DisplayName("우승한 자동차를 가져온다.")
    @Test
    void test02() {
        Winner winner = new Winner(getCars(
                getCar("name1", 1), getCar("name2", 2))
        );

        List<Car> winnerCars = winner.winnerCars();

        assertThat(winnerCars).hasSize(1)
                              .containsExactly(getCar("name2", 2));
    }

    @DisplayName("우승한 자동차들을 가져온다.")
    @Test
    void test03() {
        Winner winner = new Winner(getCars(
                getCar("name1", 1), getCar("name2", 2), getCar("name3", 2)));

        List<Car> winnerCars = winner.winnerCars();

        assertThat(winnerCars).hasSize(2)
                              .containsExactly(getCar("name2", 2), getCar("name3", 2));
    }

    private Cars getCars(Car... cars) {
        return new Cars(cars);
    }

    private Car getCar(String name, int position) {
        return new Car(name, new Position(position));
    }
}
