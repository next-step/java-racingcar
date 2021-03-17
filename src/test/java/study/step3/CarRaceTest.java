package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CarRaceTest {

    @Test
    @DisplayName("자동차 경주게임 우승자 알려주는 기능 테스트")
    void 자동차_경주_우승자(){
        Car car1 = new Car("rc11", new Position(2));
        Car car2 = new Car("rc22",new Position(1));
        Car car3 = new Car("rc33",new Position(2));
        Cars cars = Cars.of(Arrays.asList(car1,car2,car3));

        assertThat(cars.getWinners().
                stream().
                map(car -> car.getCarName())
                ).containsOnly("rc11","rc33");
    }

}
