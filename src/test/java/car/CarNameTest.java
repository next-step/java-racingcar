package car;

import car.domain.model.CarName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Assertions.assertDoesNotThrow(() -> new CarName("hello"));
    }

    @DisplayName("서로 다른 객체 인지 확인")
    @Test
    void is_not_same_object() {
        CarName carName1 = new CarName("aaa");
        CarName carName2 = new CarName("aab");

        Assertions.assertNotEquals(carName1, carName2);
    }

    @DisplayName("서로 같은 객체 인지 확인")
    @Test
    void is_same_object() {
        CarName carName1 = new CarName("aaa");
        CarName carName2 = new CarName("aaa");

        Assertions.assertEquals(carName1, carName2);
    }
}
