package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.car.CarTest.VALID_CAR_NAME;

@DisplayName("자동차 경주 - Cars 테스트")
class CarsTest {
    private final List<String> carNames = List.of(VALID_CAR_NAME, VALID_CAR_NAME);
    private final List<Integer> carPositions = List.of(5, 1, 2, 4, 3);
    private Cars movableCars;

    @BeforeEach
    public void init() {
        movableCars = createMovableCars(carPositions);
    }

    private Cars createMovableCars(List<Integer> carPositions) {
        return new Cars(carPositions.stream().map(position -> new Car(VALID_CAR_NAME, position, () -> true)).collect(Collectors.toList()));
    }

    @Test
    void Cars는_빈_컬렉션으로_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Cars(List.of());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars는_1대_미만_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Cars(List.of(), () -> true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars는_이동_전략_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Cars(carNames, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void act는_자동차_전체를_동작시킨다() {
        assertThat(movableCars.act().getCars().stream().map(Car::getPosition).collect(Collectors.toList()))
                .isEqualTo(carPositions.stream().map(position -> position + 1).collect(Collectors.toList()));
    }
}
