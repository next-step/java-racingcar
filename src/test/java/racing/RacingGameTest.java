package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private List<Car> carList;

    @BeforeEach
    void set() {
        carList = new ArrayList<>();
    }

    @Test
    @DisplayName("우승자 구하기")
    void winner() {
        Car pobi = new Car("pobi");
        pobi.move(() -> true);

        Car zeze = new Car("zeze");
        zeze.move(() -> true);
        zeze.move(() -> true);

        carList.add(pobi);
        carList.add(zeze);

        Cars cars = new Cars(carList);

        assertThat(cars.getWinners()).contains(zeze);
    }

    @Test
    @DisplayName("공동 우승자 구하기")
    void winners() {
        Car pobi = new Car("pobi");
        pobi.move(() -> true);
        pobi.move(() -> true);

        Car zeze = new Car("zeze");
        zeze.move(() -> true);
        zeze.move(() -> true);

        carList.add(pobi);
        carList.add(zeze);
        carList.add(new Car("crong"));

        Cars cars = new Cars(carList);
        assertThat(cars.getWinners()).contains(pobi, zeze);
    }
}