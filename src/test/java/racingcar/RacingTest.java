package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.domain.RacingResult;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("자동차의 위치와 이름을 가지고 있는 RacingResult로 잘 반환하는지 확인")
    void playTest() {
        Car testCar1 = new Car("yun", 0);
        Car testCar2 = new Car("yun2", 0);
        List<Car> cars = Arrays.asList(testCar1, testCar2);

        Racing racing = new Racing(cars);
        List<RacingResult> results = racing.play();

        assertThat(results).hasSize(2);
        assertThat(results.get(0).getName()).isEqualTo("yun");
        assertThat(results.get(1).getName()).isEqualTo("yun2");
        assertThat(results.get(0).getPosition()).isGreaterThanOrEqualTo(0);
        assertThat(results.get(1).getPosition()).isGreaterThanOrEqualTo(0);
    }

}
