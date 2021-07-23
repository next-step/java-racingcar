package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void init() {
        this.car = new Car();
    }

    @Test
    @DisplayName("Car 한칸 움직이기 성공 테스트")
    void move_성공_한칸() {
        car.move(4);
        assertThat(car.getPosition().getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("Car 움직이기 실패 테스트")
    void move_실패_제자리() {
        car.move(1);
        assertThat(car.getPosition().getPosition()).isEqualTo(0);
    }
}
