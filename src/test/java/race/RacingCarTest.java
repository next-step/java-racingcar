package race;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RacingCarTest {
    @Order(10)
    @Test
    void moveWithSeed() {
        RacingCar car = RacingCarFactory.create("1");
        assertThat(car.moveWithSeed(5)).isEqualTo(new Position(1));
        assertThat(car.moveWithSeed(2)).isEqualTo(new Position(1));
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
