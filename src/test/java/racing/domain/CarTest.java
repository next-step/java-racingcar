package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
<<<<<<< HEAD
=======
import racing.domain.Car;
import racing.util.RandomInt;

import java.util.Random;
>>>>>>> bcb8040e3 (feat 랜덤값 구한 후, "4 이상인 경우에만 자동차 이동 가능" 조건 추가)

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("0~8 랜덤 int 생성 ")
    void randomInt() {

<<<<<<< HEAD
        GameRule gameRule = new RandomGameRule();
        int randomNumber = gameRule.getPossibleInt();
        assertThat(randomNumber).isLessThan(9);
=======
        int randomInt = RandomInt.getPossibleInt();
        assertThat(randomInt).isLessThan(9);
>>>>>>> bcb8040e3 (feat 랜덤값 구한 후, "4 이상인 경우에만 자동차 이동 가능" 조건 추가)
    }

    @Test
    @DisplayName("자동차 이동 시 랜덤 int 만큼 거리 변화")
    void customDelimiterSum() {

<<<<<<< HEAD
        GameRule gameRule = new RandomGameRule();

        Car car = new Car(0);
        int firstRandomInt = gameRule.getPossibleInt();
        Car firstMovedCar = car.move(firstRandomInt);

        int secondRandomInt = gameRule.getPossibleInt();
        Car secondMovedCar = car.move(secondRandomInt);

        assertThat(firstMovedCar.location()).isEqualTo(firstRandomInt);
        assertThat(secondMovedCar.location() - firstMovedCar.location()).isEqualTo(secondRandomInt);
=======
        Car car = new Car(0);
        int firstRandomInt = RandomInt.getPossibleInt();
        Car firstMovedCar = car.move(firstRandomInt);

        int secondRandomInt = RandomInt.getPossibleInt();
        Car secondMovedCar = car.move(secondRandomInt);

        assertThat(firstMovedCar.getLocation()).isEqualTo(firstRandomInt);
        assertThat(secondMovedCar.getLocation() - firstMovedCar.getLocation()).isEqualTo(secondRandomInt);
>>>>>>> bcb8040e3 (feat 랜덤값 구한 후, "4 이상인 경우에만 자동차 이동 가능" 조건 추가)
    }
}
