package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static race.util.RandomNumberUtil.getRandomNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("number 값이 4 이상인 경우 1 아닌 경우 0")
    void moveTest(int number) {
        Car car = new Car("test");
        car.move(number);
        int position = car.getPosition();

        if (4 <= number) {
            assertThat(position).isEqualTo(1);
        } else {
            assertThat(position).isEqualTo(0);
        }
    }
}