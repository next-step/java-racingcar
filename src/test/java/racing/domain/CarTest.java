package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("test");
    }

    @Test
    void 자동차_전진_테스트() {
        // given
        RaceRule raceRule = () -> true;

        // when
        car.move(raceRule);

        // then
        assertThat(car.getDistance()).isNotZero();
    }
}
