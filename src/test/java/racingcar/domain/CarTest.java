package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private final int DEFAULT_POSITION = 0;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"4|GO_FORWARD", "9|GO_FORWARD", "0|STOP", "1|STOP"}, delimiter = '|')
    void 자동차는_4_이상_숫자를_입력하면_전진한다(int actionNo, CarAction carAction) {
        assertThat(car.decideAction(actionNo)).isEqualTo(carAction);
    }

    @Test
    void 자동차는_전진_하거나_멈춘다() {
        car.act();
        assertThat(car.getPosition()).isIn(DEFAULT_POSITION, DEFAULT_POSITION + 1);
    }

    @Test
    void 자동차는_현재_위치를_나타낸다() {
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void 자동차는_전진하면_위치가_1_증가한다() {
        car.goForward();
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }
}
