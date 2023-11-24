package racing;

import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.TestGenerateNumber;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racing.domain.Car.isMove;
import static racing.domain.RacingGame.splitCarName;

public class CarsTest {

    @Test
    void 경기가_끝나면_우승한_자동차를_가져올_수_있다() {
        Car car1 = new Car("A", 3);
        Car car2 = new Car("B", 2);
        Car car3 = new Car("C", 1);
        Cars cars = new Cars(List.of(car1, car2, car3));

        String winners = cars.getWinner();

        assertThat(winners).isEqualTo("A");
    }

    @Test
    void 경기가_끝나면_우승한_자동차를_가져올_수_있다_여러명() {
        Car car1 = new Car("Q", 5);
        Car car2 = new Car("W", 2);
        Car car3 = new Car("E", 5);

        Cars cars = new Cars(List.of(car1, car2, car3));

        String winners = cars.getWinner();

        assertThat(winners).isEqualTo("Q,E");
    }
}
