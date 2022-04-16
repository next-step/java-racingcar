package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("자동차 경주 - Cars 테스트")
class CarsTest {
    private final List<Integer> carPositionList = List.of(5, 1, 2, 4, 3);
    private Cars movableCars;

    @BeforeEach
    public void init() {
        movableCars = createMovableCars(carPositionList);
    }

    private Cars createMovableCars(List<Integer> carPositionList) {
        return new Cars(carPositionList.stream().map(position -> new Car(position, () -> true)).collect(Collectors.toList()));
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
            new Cars(0, () -> true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars는_이동_전략_없이_생성_할_경우_런타임_예외를_발생_시킨다() {
        assertThatThrownBy(() -> {
            new Cars(4, null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void act는_자동차_전체를_동작시킨다() {
        assertThat(movableCars.act().getCarPositions())
                .isEqualTo(carPositionList.stream().map(position -> position + 1).collect(Collectors.toList()));
    }

    @Test
    void getCarPositions은_자동차들의_현재위치_리스트를_반환한다() {
        assertThat(movableCars.getCarPositions()).isEqualTo(carPositionList);
    }
}
