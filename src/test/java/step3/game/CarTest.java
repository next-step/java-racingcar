package step3.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.game.domain.car.Car;
import step3.game.domain.car.CarName;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차는 4 이상의 값일 때 전진할 수 있다.")
    @ValueSource(ints = {4, 5, 6})
    void carCanMove() {
        Car car = new Car(new CarName("test"));
        Car movedCar = car.moveIfPossible(5);
        assertThat(movedCar.getDistance()).isEqualTo(1);
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
