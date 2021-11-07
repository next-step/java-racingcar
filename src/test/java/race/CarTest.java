package race;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void move() {
        Car car = new Car();
        int moveCount = (new Random()).nextInt(100);

        for (int i = 0; i < moveCount; i++) {
            car.move();
        }

        assertThat(car.location()).isEqualTo(moveCount);
    }
}
