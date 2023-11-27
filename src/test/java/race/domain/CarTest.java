package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static race.util.RandomNumberUtil.getRandomNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤 값이 4 이상인 경우 1 아닌 경우 0")
    void moveTest() {
        Car car = new Car();
        int randomNumber = getRandomNumber();
        car.move(randomNumber);
        int position = car.getPosition();

        if (4 <= randomNumber) {
            assertThat(position).isEqualTo(1);
        } else {
            assertThat(position).isEqualTo(0);
        }
    }
}