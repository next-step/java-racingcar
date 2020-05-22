package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;
    private int random;
    private RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        car = new Car(0, 0);
        randomNumber = new RandomNumber();
        random = randomNumber.getRandomNumber();
    }

    @Test
    @DisplayName("Random값이 4이상일 때 Car 이동")
    void moveTest() {
        if (random >= 4) {
            assertThat(car.move(random)).isEqualTo(1);
        }
    }
}
