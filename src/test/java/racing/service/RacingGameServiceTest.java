package racing.service;

import org.junit.jupiter.api.Test;
import racing.controller.RacingGameController;
import racing.model.Car;
import racing.model.CarPosition;
import racing.model.DefaultCar;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {
    @Test
    void 자동차_3대를_생성하면_정상적으로_3대가_생성되는지() {
        String[] names = {"a", "b", "c"};
        assertThat(new RacingGameSerice(names).generateCar(names).size()).isEqualTo(3);
    }

    @Test
    void 가장_멀리_이동한_차가_우승자이다() {
        List<Car> cars = new ArrayList<>();
        cars.add(new DefaultCar("a", new CarPosition(2)));
        cars.add(new DefaultCar("b", new CarPosition(4)));
        cars.add(new DefaultCar("c", new CarPosition(3)));

        String[] test = {};

        assertThat(new RacingGameSerice(test).getWinner(cars).get(0)).isEqualTo(cars.get(1));
    }
}
