package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("숫자가 4 미만이면 움직이지 않는다.")
    @Test
    void moveTestSmallerThanFour() {
        Car car = new Car();
        NumberGenerator numberGenerator = new StaticNumberGenerator(3);

        car.move(numberGenerator);

        assertThat(car.getCurrentPosition()).extracting("value").isEqualTo(0);
    }

    @DisplayName("숫자가 4 이상이면 움직인다.")
    @Test
    void moveTestLargerThanOrEqualToFour() {
        Car car = new Car();
        NumberGenerator numberGenerator = new StaticNumberGenerator(5);

        car.move(numberGenerator);

        assertThat(car.getCurrentPosition()).extracting("value").isEqualTo(1);
    }
}