package racing;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.NumberAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car = new Car();
    Car[] carArr = new Car[5];

    @Test
    void setCarName() {
        Assertions.assertThat("TOMMY");
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> car.setCarName("TOMMYBEAR"));
    }

    @Test
    @DisplayName("무작위값이 0~9사이값이 나오는지 테스트")
    void carRun() {
        int distance = 0;

        for(int i=0; i < 100000; i++) {
            distance = car.carRun();
            Assertions.assertThat(distance).isBetween(0, 9);
        }
    }

    @Test
    void statusPrint() {
        car.setDistance(8);
        car.setCarName("Tommy");
        String resultText = car.statusPrint();
        Assertions.assertThat(resultText).isEqualTo("Tommy : 8");
    }
}