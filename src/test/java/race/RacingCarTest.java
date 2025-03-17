package race;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class FixedNumberGenerator implements RandomNumberGenerator {
    private final int fixedValue;

    public FixedNumberGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int generate() {
        return fixedValue;
    }
}

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RacingCarTest {
    @Order(10)
    @Test
    void move() {
        RacingCar car = new RacingCar(1, new FixedNumberGenerator(5));
        assertThat(car.move()).isEqualTo(1);
        assertThat(car.move()).isEqualTo(2);
    }

    @Order(20)
    @Test
    void not_move() {
        RacingCar car = new RacingCar(1, new FixedNumberGenerator(2));
        assertThat(car.move()).isEqualTo(0);
        assertThat(car.move()).isEqualTo(0);
    }

    @Test
    void move() {
        RacingCar car = new RacingCar();
        assertThat(car.move(5)).isEqualTo("-");
        assertThat(car.move(9)).isEqualTo("--");
    }

    @Test
    void not_move() {
        RacingCar car = new RacingCar();
        assertThat(car.move(5)).isEqualTo("-");
        assertThat(car.move(0)).isEqualTo("-");
    }
}
