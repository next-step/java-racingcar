package racing;

import jdk.jfr.Name;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    @Name("경주 준비 자동차 생성 테스트")
    @Test
    void ready() {
        // given
        Racing racing = new Racing();
        int numberOfCar = 3;

        // when
        List<Car> cars = racing.ready(numberOfCar);

        // then
        assertThat(cars.size()).isEqualTo(numberOfCar);
    }
}
