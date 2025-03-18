package step3.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.domain.car.Car;
import step3.game.domain.car.CarName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void carCanMove() {
        Car car = new Car(new CarName("test"));
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 이름은 5자를 초과할 수 없다.")
    void carNameLength() {
        assertDoesNotThrow(() -> new CarName("test"));
    }

    @Test
    @DisplayName("자동차의 이름은 5자보다 길면 예외가 발생한다.")
    void carNameLengthOverLimit() {
        assertThrows(RuntimeException.class, () -> new CarName("longname"));
    }

}
