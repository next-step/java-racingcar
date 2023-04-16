package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.util.RandomInt;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("0~8 랜덤 int 생성 ")
    void randomInt() {

        int randomInt = RandomInt.getPossibleInt();
        assertThat(randomInt).isLessThan(9);
    }

    @Test
    @DisplayName("자동차 이동 시 랜덤 int 만큼 거리 변화")
    void customDelimiterSum() {

        Car car = new Car(0);
        int firstRandomInt = RandomInt.getPossibleInt();
        Car firstMovedCar = car.move(firstRandomInt);

        int secondRandomInt = RandomInt.getPossibleInt();
        Car secondMovedCar = car.move(secondRandomInt);

        assertThat(firstMovedCar.getLocation()).isEqualTo(firstRandomInt);
        assertThat(secondMovedCar.getLocation() - firstMovedCar.getLocation()).isEqualTo(secondRandomInt);
    }
}
