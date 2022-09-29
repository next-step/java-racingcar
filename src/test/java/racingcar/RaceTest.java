package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private final Race race = new Race(new String[]{});
    @Test
    @DisplayName("우승자가 한명일때 우승자 찾기")
    void 우승자_한명_찾기() {

        List<Car> cars = List.of(
                new Car("car1", 3),
                new Car("car2", 5),
                new Car("car3", 7)
        );
        List<Car> winner = race.findWinner(cars);
        assertThat(winner.get(0).getCarName()).isEqualTo("car3");
    }

    @Test
    @DisplayName("우승자가 여러명일때 우승자 찾기")
    void 우승자_여러명_찾기() {
        List<Car> cars = List.of(
                new Car("car1", 5),
                new Car("car2", 3),
                new Car("car3", 5)
        );
        List<Car> winner = race.findWinner(cars);
        assertThat(winner.size()).isEqualTo(2);
    }
}
