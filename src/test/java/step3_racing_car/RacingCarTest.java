package step3_racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3_racing_car.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("입력한 값 만큼 거리를 잘 이동하는지 검증한다")
    void move() {
        RacingCar car = new RacingCar("자동차1");
        car.movePositions(3);
        assertThat(car)
                .usingRecursiveComparison()
                .isEqualTo(new RacingCar("자동차1", 3));
    }

    @Test
    @DisplayName("경주차의 이름이 5자를 초과하면 exception을 발생시킨다.")
    void nameValidation() {
        assertThatThrownBy(() -> {
            RacingCar car = new RacingCar("자동차이름이");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
