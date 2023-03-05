package racing;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.NumberAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;
    Car[] carArr = new Car[5];

    @Test
    @DisplayName("5자리 초과한 경우 정상적으로 오류체크 되는지 확인")
    void 자동차이름자리수체크() {
        Assertions.assertThat(new Car("Tommy"));
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("TommyBear"));
    }

    @Test
    @DisplayName("무작위값이 0~9사이값이 나오는지 테스트")
    void 무작위랜던값확인() {
        for(int i=0; i < 100000; i++) {
            Assertions.assertThat((int) (Math.random() * 10)).isBetween(0, 9);
        }
    }

    @Test
    void statusPrint() {
        car = new Car("Tommy", 8);
        String resultText = car.statusPrint();
        Assertions.assertThat(resultText).isEqualTo("Tommy : 8");
    }
}