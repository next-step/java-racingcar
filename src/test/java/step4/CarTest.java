package step4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.Car;
import step3.RandomMoveStrategy;

public class CarTest {

    private step3.Car car;

    @BeforeEach
    void init() {
        car = new Car(new RandomMoveStrategy());
    }

    @Test
    void moveSuccess() {
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
