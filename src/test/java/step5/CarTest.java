package step5;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void init() {
        car = new Car("kim", new RandomMoveStrategy());
    }

    @Test
    void move() {
        car.move();
        assertThat(car.getPosition()).isIn(Arrays.asList(0, 1));
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
