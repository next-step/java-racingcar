package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.validCarName;
import static racingcar.domain.car.CarPositionTest.defaultPosition;
import static racingcar.domain.car.CarPositionTest.winnerPosition;

@DisplayName("자동차 경주 - Car 테스트")
public class CarTest {
    private static final int MOVED_POSITION = 1;
    private static final int DEFAULT_POSITION = 0;
    private static final String WINNER_NAME = "win";
    static final int MOVABLE_DISTANCE = 1;

    static final Car winnerCar = new Car(new CarName(WINNER_NAME), winnerPosition, () -> true);
    static final Car defaultCar = new Car(validCarName, defaultPosition, () -> true);

    private Car movableCar;
    private Car nonMovableCar;

    @BeforeEach
    void setUp() {
        movableCar = new Car(validCarName, () -> true);
        nonMovableCar = new Car(validCarName, () -> false);
    }

    @Test
    void Car는_이름과_이동전략으로_생성이_가능하다() {
        assertThat(new Car(validCarName, new RandomMoveStrategy()))
                .isInstanceOf(Car.class);
    }

    @Test
    void Car는_이름_위치_이동전략으로_생성이_가능하다() {
        assertThat(new Car(validCarName, defaultPosition, new RandomMoveStrategy()))
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
            new Car(validCarName, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
