package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - Car 테스트")
public class CarTest {
    private static final int DEFAULT_POSITION = 0;
    private static final String VALID_CAR_NAME = "왕민";
    private static final String OVERSIZE_CAR_NAME = "wangmin";

    private Car movableCar;
    private Car nonMovableCar;

    @BeforeEach
    void setUp() {
        movableCar = new Car(VALID_CAR_NAME, () -> true);
        nonMovableCar = new Car(VALID_CAR_NAME, () -> false);
    }

    @Test
    void 자동차는_전진한다() {
        assertThat(movableCar.act().getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }

    @Test
    void 자동차는_멈춘다() {
        assertThat(nonMovableCar.act().getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void 자동차는_현재_위치를_나타낸다() {
        assertThat(movableCar.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void 자동차는_전진하면_위치가_1_증가한다() {
        assertThat(movableCar.act().getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }

    @Test
    void Car는_carActionStrategy없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Car(VALID_CAR_NAME, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {OVERSIZE_CAR_NAME, " ", ""})
    void Car는_name이_올바르지_않을경우_런타임_예외를_발생_시킨다(String name) {
        assertThatThrownBy(() -> {
            new Car(name, new RandomMoveStrategy());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
