package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class CarGroupTest {
    @Test
    void 자동차_갯수_음수일떄() {
        assertThatThrownBy(() -> {
            CarGroup.createCars(-1, 3);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 시도_횟수_음수일떄() {
        assertThatThrownBy(() -> {
            CarGroup.createCars(3, -1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 자동차그룹의_자동차_갯수가_같다() {
        List<Car> cars = CarGroup.createCars(3, 2);
        assertThat(cars).hasSize(3);
    }

}