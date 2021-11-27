package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private final List<Car> initialCarList = new ArrayList<>(Arrays.asList(new Car("이름1", 0), new Car("이름2", 0), new Car("이름3", 0)));
    private final Cars cars1 = new Cars(initialCarList);

    @Test
    @DisplayName("Racing 후 car 컬렉션 상태 체크")
    void carNumberTest() {

        cars1.doRacing();
        cars1.getCars().forEach(car -> assertThat(car.getLocation()).isBetween(0, 1));
    }
}
