package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.game.domain.Car;
import step2.game.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("+1 칸 전진하는 자동차 테스트")
    void move_plus_1() {
        Car car = new Car(1, new CarName("pobi"), () -> true);
        Car movedCar = car.move();
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("무조건 정지하는 자동차 테스트")
    void move_stop() {
        Car car = new Car(1, new CarName("pobi"), () -> false);
        Car movedCar = car.move();
        assertThat(movedCar.getPosition()).isEqualTo(0);
    }

}
