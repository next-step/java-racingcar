package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.racing.Racing.*;

public class RacingTest {
    List<Car> cars = new ArrayList<>();

    @BeforeEach
    void init() {
        cars.add(new Car("애플"));
        cars.add(new Car("삼성"));
        cars.add(new Car("구글"));
    }

    @Test
    void 자동차_초기화_성공() {
        String[] carsArray = {"애플", "삼성", "구글"};
        List<Car> cars = initCars(carsArray);
        assertThat(cars).hasSize(3);
        assertThat(cars).containsExactly(new Car("애플"), new Car("삼성"), new Car("구글"));
    }

    @Test
    void 경주시작_임의값_성공() {
        String carsName = "애플,삼성,구글";
        racingStart(carsName, 5);
    }

    @Test
    void 자동차_전진_성공() {
        moveCarForward(cars);
    }
}
