package game.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : yusik
 * @date : 2019/10/26
 */
public class CarTest {

    @DisplayName("자동차 이름 반환")
    @Test
    void getName() {

        // given
        String expected = "test-name";
        DefaultCar car = new DefaultCar(expected, new TrackingLog(expected));

        // when, then
        assertThat(car.getName()).isEqualTo(expected);
    }

    @DisplayName("자동차 이동 추적 로그")
    @Test
    void move() {

        // given
        int expected = 10;
        String name = "test-name";
        TrackingLog log = new TrackingLog(name);
        DefaultCar car = new DefaultCar(name, log);

        // when
        IntStream.range(0, expected).forEach(i -> car.move());

        // then
        assertThat(log.getSize()).isEqualTo(expected);
    }
}
