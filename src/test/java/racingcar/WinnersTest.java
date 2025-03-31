package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class WinnersTest {
    @Test
    @DisplayName("공동 우승자")
    void many() {
        String name1 = "test1";
        String name2 = "test2";
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(name1));
        cars.add(new Car(name2));

        Winners winners = new Winners(cars);

        assertThat(winners.getNames())
                .contains(name1, name2);
    }
}
