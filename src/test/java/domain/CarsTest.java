package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.as;

public class CarsTest {
    @DisplayName("입력받은 숫자만큼 자동차를 생성한다.")
    @Test
    void generateCarsTest() {
        int numberOfCars = 3;

        Cars cars = new Cars(numberOfCars);

        assertThat(cars).extracting("cars").asInstanceOf(list(Car.class)).hasSize(numberOfCars);
    }

    @DisplayName("숫자가 4 미만이면 움직이지 않는다.")
    @Test
    void moveTestSmallerThanFour() {
        Cars cars = new Cars(1);
        NumberGenerator numberGenerator = new StaticNumberGenerator(3);

        cars.move(numberGenerator);

        assertThat(cars.getCurrentPositions()).first().extracting("value").isEqualTo(0);
    }

    @DisplayName("숫자가 4 이상이면 움직인다.")
    @Test
    void moveTestLargerThanOrEqualToFour() {
        Cars cars = new Cars(1);
        NumberGenerator numberGenerator = new StaticNumberGenerator(5);

        cars.move(numberGenerator);

        assertThat(cars.getCurrentPositions()).first().extracting("value").isEqualTo(1);
    }
}