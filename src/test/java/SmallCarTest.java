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
