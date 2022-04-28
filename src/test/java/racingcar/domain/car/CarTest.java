package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;
import static racingcar.domain.car.CarNameTest.WINNER_CAR_NAME;
import static racingcar.domain.car.CarPositionTest.WINNER_CAR_POSITION;

@DisplayName("자동차 경주 - Car 테스트")
public class CarTest {
    private static final int MOVED_POSITION = 1;
    private static final int DEFAULT_POSITION = 0;

    static final Car WINNER_CAR = new Car(WINNER_CAR_NAME, WINNER_CAR_POSITION, () -> true);
    static final Car DEFAULT_CAR = new Car(VALID_CAR_NAME, CarPositionTest.DEFAULT_CAR_POSITION, () -> true);

    private Car movableCar;
    private Car nonMovableCar;

    @BeforeEach
    void setUp() {
        movableCar = new Car(VALID_CAR_NAME, () -> true);
        nonMovableCar = new Car(VALID_CAR_NAME, () -> false);
    }

    @Test
    void Car는_이름과_이동전략으로_생성이_가능하다() {
        assertThat(new Car(VALID_CAR_NAME, new RandomMoveStrategy()))
                .isInstanceOf(Car.class);
    }

    @Test
    void Car는_이름_위치_이동전략으로_생성이_가능하다() {
        assertThat(new Car(VALID_CAR_NAME, CarPositionTest.DEFAULT_CAR_POSITION, new RandomMoveStrategy()))
                .isInstanceOf(Car.class);
    }

    @Test
    void 자동차는_전진한다() {
        assertThat(movableCar.act().getPosition()).isEqualTo(MOVED_POSITION);
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
        assertThat(movableCar.act().getPosition()).isEqualTo(MOVED_POSITION);
    }

    @Test
    void Car는_carActionStrategy없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Car(VALID_CAR_NAME, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isWinner는_승리_여부를_반환한다() {
        assertAll(
                () -> assertTrue(WINNER_CAR.isWinner(WINNER_CAR_POSITION.getPosition())),
                () -> assertFalse(DEFAULT_CAR.isWinner(WINNER_CAR_POSITION.getPosition()))
        );
    }
}
