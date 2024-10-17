package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("자동차의 위치와 이름을 가지고 있는 RacingResult로 잘 반환하는지 확인")
    void playTest() {
        Car testCar1 = new Car(new CarName("yun"), new CarPosition(0));
        Car testCar2 = new Car(new CarName("yun2"), new CarPosition(0));
        List<Car> cars = Arrays.asList(testCar1, testCar2);

        Random random = new Random();
        Racing racing = new Racing(cars, random);
        List<RacingResult> results = racing.play();

        assertThat(results).hasSize(2);
        assertThat(results.get(0).getName()).isEqualTo("yun");
        assertThat(results.get(1).getName()).isEqualTo("yun2");
        assertThat(results.get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(results.get(1).getPosition()).isGreaterThanOrEqualTo(0);
    }

}
