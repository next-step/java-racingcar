package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.InstanceOfAssertFactories.list;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.BDDAssertions.as;

public class CarsTest {
    @DisplayName("숫자가 4 미만이면 움직이지 않는다.")
    @Test
    void moveTestSmallerThanFour() {
        Cars cars = new Cars(1);
        NumberGenerator numberGenerator = new StaticNumberGenerator(3);

        cars.move(numberGenerator);

        assertThat(cars)
                .extracting("cars", as(list(Car.class)))
                .first()
                .extracting("position")
                .extracting("value")
                .isEqualTo(0);
    }

    @DisplayName("숫자가 4 이상이면 움직인다.")
    @Test
    void moveTestLargerThanOrEqualToFour() {
        Cars cars = new Cars(1);
        NumberGenerator numberGenerator = new StaticNumberGenerator(5);

        cars.move(numberGenerator);

        assertThat(cars)
                .extracting("cars", as(list(Car.class)))
                .first()
                .extracting("position")
                .extracting("value")
                .isEqualTo(1);
    }

    @DisplayName("print 테스트")
    @Test
    void printTest() {
        Cars cars = new Cars(1);
        NumberGenerator numberGenerator = new StaticNumberGenerator(5);

        cars.move(numberGenerator);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        cars.printCurrentPositions();

        assertThat(output.toString()).isEqualTo("-\n");
    }
}