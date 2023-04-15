package racing;

import calculate.Operand;
import calculate.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("1~8 랜덤 int 생성 ")
    void randomInt() {

        Random random = new Random();
        int randomPower = random.nextInt(8) + 1; // 1~8
        System.out.println("randomPower = " + randomPower);

        assertThat(randomPower).isLessThan(9);
    }

    @Test
    @DisplayName("자동차 객체 생성 및 1회 이동")
    void customDelimiterSum() {

        Car car = new Car();
        int firstLocation = car.move().getLocation();

        System.out.println("firstLocation = " + firstLocation);
        assertThat(firstLocation).isLessThan(9);

    }
}
