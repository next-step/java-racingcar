package step3.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    private Car car = new Car();

    @ParameterizedTest
    @DisplayName("0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상인 경우 전진한다")
    @ValueSource(ints = {4, 7, 9})
    void tryMove_Move(int randomValue) {
        //when
        car.tryMove(randomValue);

        //then
        Position actual = car.getCurrentPosition();
        assertEquals(new Position(1), actual);
    }

    @ParameterizedTest
    @DisplayName("0에서 9 사이에서 random 값을 구한 후 random 값이 4 미만인 경우 stay")
    @ValueSource(ints = {0, 1, 3})
    void tryMove_Stay(int randomValue) {
        //when
        car.tryMove(randomValue);

        //then
        Position actual = car.getCurrentPosition();
        assertEquals(new Position(0), actual);
    }

    @ParameterizedTest
    @DisplayName("random 값의 범위는 0 <= randomValue <= 9여야 한다")
    @ValueSource(ints = {-1, 10})
    void randomValueValidation(int randomValue) {
        assertThrows(IllegalArgumentException.class, () -> car.tryMove(randomValue));
    }
}
