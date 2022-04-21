package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarNameTest.VALID_CAR_NAME;

@DisplayName("자동차 경주 - Car 테스트")
public class CarTest {
    private Car movableCar;
    private Car nonMovableCar;
    private CarPosition movedPosition;
    private CarPosition defaultPosition;
    private CarName carName = new CarName(VALID_CAR_NAME);

    @BeforeEach
    void setUp() {
        movableCar = new Car(carName, () -> true);
        nonMovableCar = new Car(carName, () -> false);
        movedPosition = movableCar.getPosition().increase();
        defaultPosition = CarPosition.createDefault();
    }

    @Test
    void 자동차는_전진한다() {
        assertThat(movableCar.act().getPosition()).isEqualTo(movedPosition);
    }

    @Test
    void 자동차는_멈춘다() {
        assertThat(nonMovableCar.act().getPosition()).isEqualTo(defaultPosition);
    }

    @Test
    void 자동차는_현재_위치를_나타낸다() {
        assertThat(movableCar.getPosition()).isEqualTo(defaultPosition);
    }

    @Test
    void 자동차는_전진하면_위치가_1_증가한다() {
        assertThat(movableCar.act().getPosition()).isEqualTo(movedPosition);
    }

    @Test
    void Car는_carActionStrategy없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Car(carName, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
