package race;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

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
        RacingCar car = RacingCarFactory.create("1", new FixedNumberGenerator(5));
        assertThat(car.move()).isEqualTo(1);
        assertThat(car.move()).isEqualTo(2);
    }

    @Order(20)
    @Test
    void not_move() {
        RacingCar car = RacingCarFactory.create("1", new FixedNumberGenerator(2));
        assertThat(car.move()).isEqualTo(0);
        assertThat(car.move()).isEqualTo(0);
    }

    @Order(30)
    @Test
    void valid_car_name() {
        assertThat(RacingCar.validateName("test")).isTrue();
    }

    @Order(40)
    @Test
    void invalid_car_name() {
        assertThat(RacingCar.validateName("")).isFalse();
        assertThat(RacingCar.validateName("aaaaaaa")).isFalse();
    }
}
