package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racinggame.domain.Car.CAR_NAME_STANDARD;

public class CarTest {
    @DisplayName("우승자인지 여부")
    @Test
    void winnerCar() {
        AlwaysMoveForward alwaysMoveForward = new AlwaysMoveForward();
        Car car = new Car("saem");
        car.move(alwaysMoveForward);
        car.move(alwaysMoveForward);
        assertThat(car.isWinner(2)).isTrue();
        assertThat(car.isWinner(3)).isFalse();
    }

    @DisplayName("자동차 이름은" + CAR_NAME_STANDARD + "자를 초과할 수 없습니다.")
    @Test
    void carNaming() {
        assertThatThrownBy(() -> new Car("dosaem"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 %d자를 초과할 수 없습니다.", CAR_NAME_STANDARD));
    }

    @DisplayName("자동차 이름 입력받기 테스트")
    @Test
    void carNameInput() {
        Car car = new Car("saem");
        assertThat(car.getName()).isEqualTo("saem");
    }

}
