package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car = new Car();

    @Test
    public void 랜덤값_4이상이면_전진() {
        car.play(createRandom(4));
        assertThat(car.getPos()).isEqualTo(1);
    }

    @Test
    public void 랜덤값_4미만이면_멈출() {
        car.play(createRandom(3));
        assertThat(car.getPos()).isEqualTo(0);
    }

    private Random createRandom(int value) {
        return new Random() {
            public int nextInt(int bound) {
                return value;
            }
        };
    }
}
