package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar4.model.Car;


import static org.assertj.core.api.Assertions.assertThat;
public class RacingCar4CarTest {

    @DisplayName("글자가 5글자가 넘으면 ERROR 발생")
    @Test
    void randomNumber() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("mimimi")).withMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차의 이름을 잘 갖고온다.")
    @Test
    void nameCar() {
        Car car = new Car("shy");
        assertThat(car.getName()).isEqualTo("shy");
    }

}
