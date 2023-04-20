package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("0~8 랜덤 int 생성 ")
    void randomInt() {

        GameRule gameRule = new RandomGameRule();
        int randomNumber = gameRule.getPossibleInt();
        assertThat(randomNumber).isLessThan(9);
    }

    @Test
    @DisplayName("자동차 이동 시 랜덤 int 만큼 거리 변화")
    void customDelimiterSum() {

        GameRule gameRule = new RandomGameRule();

        Car car = new Car(0);
        int firstRandomInt = gameRule.getPossibleInt();
        Car firstMovedCar = car.move(firstRandomInt);

        int secondRandomInt = gameRule.getPossibleInt();
        Car secondMovedCar = car.move(secondRandomInt);

        assertThat(firstMovedCar.location()).isEqualTo(firstRandomInt);
        assertThat(secondMovedCar.location() - firstMovedCar.location()).isEqualTo(secondRandomInt);
    }
}
