package logictest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

import input.InputForm;
import logic.Car;
import logic.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_정상 () {
        String carName = "pobi";
        assertThatCode(()->new Car(carName)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_오류 () {
        String carName = "pobiii";
        assertThrows(RuntimeException.class, ()-> new Car(carName));
    }
}
