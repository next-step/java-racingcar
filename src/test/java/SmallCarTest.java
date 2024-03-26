import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jeongheekim
 * @date 3/18/24
 */
class SmallCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    @DisplayName("random 값이 4이상일 경우 앞으로 전진한다.")
    void whenRandom4goDriveTest(int randomNumber) {
        SmallCar car = new SmallCar("pobi");
        car.drive(randomNumber,"-");
        assertTrue(car.getStatus().length() > 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("random 값이 4미만일 경우 전진하지 않는다.")
    void whenRandom4NotDriveTest(int randomNumber) {
        SmallCar car = new SmallCar("pobi");
        car.drive(randomNumber,"-");
        assertTrue(car.getStatus().length() == 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void carNameNotOverLength(int length) {
        SmallCar car = new SmallCar("pobi");
        String name = car.getName();
        assertTrue(name.length() <= length);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void carNameNotOverLength2(int length) {
        SmallCar car = new SmallCar("pobipobi");
        String name = car.getName();
        assertFalse(name.length() <= length);
    }

}
