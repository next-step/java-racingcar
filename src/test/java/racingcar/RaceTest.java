package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    @Test
    @DisplayName("우승자가 한명일때 우승자 찾기")
    void 우승자_한명_찾기() {

        Car car1 = new Car("car1", 3);
        Car car2 = new Car("car2", 5);
        Car car3 = new Car("car3", 7);

        List<Car> cars = List.of(car1, car2, car3);
        List<Car> winner = Race.findWinners(cars);
        assertThat(winner).contains(car3);
    }

    @Test
    @DisplayName("우승자가 여러명일때 우승자 찾기")
    void 우승자_여러명_찾기() {
        List<Car> cars = List.of(
                new Car("car1", 5),
                new Car("car2", 3),
                new Car("car3", 5)
        );
        List<Car> winner = Race.findWinners(cars);
        assertThat(winner.size()).isEqualTo(2);
    }
}
