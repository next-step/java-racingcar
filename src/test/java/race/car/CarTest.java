package race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
public class CarTest {


    @ParameterizedTest(name = "{index} => movePower={0}, moveDiatance={1}, resultValue{2}")
    @CsvSource({
            "9, 0, 1",
            "3, 3, 3",
            "2, 6, 6"
    })
    @DisplayName("자동차가 이동을 했는지")
    void isMove(int movePower, int moveDiatance, int resultValue){
        assertEquals(Car.moveCarCheck(moveDiatance, movePower), resultValue);
    }
}
