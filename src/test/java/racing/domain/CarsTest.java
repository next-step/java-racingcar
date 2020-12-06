package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차들(Cars) 테스트")
public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.of(Arrays.asList(
                Car.of(1, 1),
                Car.of(2, 2),
                Car.of(3, 3),
                Car.of(4, 4)
        ));
    }

    @DisplayName("자동차들(Cars)은 자동차(Car)로 생성된다.")
    @Test
    void create() {
        // when / then
        assertThat(cars).isNotNull();
    }

    @DisplayName("각 판마다 자동차(Car)들을 움직일 수 있다.")
    @Test
    void forward() {
        // given
        Moveable moveable = () -> true;

        // when
        Cars forward = cars.forward(moveable);

        // then
        assertThat(forward).isEqualTo(Cars.of(Arrays.asList(
                Car.of(1, 2),
                Car.of(2, 3),
                Car.of(3, 4),
                Car.of(4, 5))));
    }

    @DisplayName("판 보고서(RoundReport)를 만들 수 있다.")
    @Test
    void report() {
        // when
        RoundReport roundReport = cars.report();

        // then
        assertThat(roundReport).isNotNull();
    }
}
