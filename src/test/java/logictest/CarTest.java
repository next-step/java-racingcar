package logictest;

import static org.assertj.core.api.Assertions.assertThatCode;

import input.InputForm;
import logic.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("자동차 입력이 정상적인지 확인")
    void 자동차_이름_테스트_정상 () {
        String carName = "pobi";
        assertThatCode(()->new Car(carName)).doesNotThrowAnyException();
    }

}
