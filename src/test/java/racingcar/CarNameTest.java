package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.CarName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameTest {

    @Test
    void test_자동차_이름을_5자_초과하여_생성() {
        String name = "일곱글자입니다";

        assertThrows(IllegalArgumentException.class, () -> new CarName(name));
    }

    @Test
    void test_자동차_정상적으로_생성() {
        String name = "다섯글자임";
        CarName carName = new CarName(name);

        assertEquals(name, carName.getName());
    }

}
