package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("자동차 이름을 반환한다.")
    @Test
    void getNameTest() {
        String name = "pobi";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("현재 위치를 반환한다.")
    @Test
    void getCurrentPositionTest() {
        Car car = new Car("pobi");

        assertThat(car.getPosition()).extracting("value").isEqualTo(0);
    }

    @DisplayName("숫자가 4 미만이면 움직이지 않는다.")
    @Test
    void moveTestSmallerThanFour() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = new StaticNumberGenerator(3);

        car.move(numberGenerator);

        assertThat(car.getPosition()).extracting("value").isEqualTo(0);
    }

    @DisplayName("숫자가 4 이상이면 움직인다.")
    @Test
    void moveTestLargerThanOrEqualToFour() {
        Car car = new Car("pobi");
        NumberGenerator numberGenerator = new StaticNumberGenerator(5);

        car.move(numberGenerator);

        assertThat(car.getPosition()).extracting("value").isEqualTo(1);
    }
}