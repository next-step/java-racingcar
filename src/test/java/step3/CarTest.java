package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class CarTest {

    Car car = new Car();

    @Test
    void move() {
        car.move();
    }

    @Test
    void randomNumber() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            assertThat(randomNumber).isIn(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        }
    }
}
