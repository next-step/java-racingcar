package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("go하면 포지션이 증가하는지 확인")
    @Test
    public void goTest() {
        Car car = new Car("Audi");
        int position = car.getPosition();
        car.go();
        assertThat(car.getPosition()).isEqualTo(position + 1);
    }

}