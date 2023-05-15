package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void proceedOrStop함수는_0_또는_1을_반환한다() {
        // Given
        Car car = new Car("pobi", Arrays.asList(1, 2, 3, 4, 4));

        // Then
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
        assertThat(car.proceedOrStop()).isIn(0, 1);
    }

    @Test
    void Car_객체_테스트() {
        // Given
        Car car = new Car("pobi", Arrays.asList(1, 2, 3, 4, 5));

        // Then
        assertThat(car.getName()).isEqualTo("pobi");
        assertThat(car.getPositions()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("pobibi", Arrays.asList(1, 2, 3, 4, 5));
        }).withMessage("자동차 이름은 5자를 초과할 수 없다.");
    }
}