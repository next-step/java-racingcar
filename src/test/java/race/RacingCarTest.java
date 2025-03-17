package race;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RacingCarTest {
//    @Order(10)
//    @Test
//    void should_move_over_4() {
//        RacingCar car = new RacingCar();
//        assertThat(car.shouldMove(4)).isTrue();
//        assertThat(car.shouldMove(9)).isTrue();
//    }
//
//    @Order(20)
//    @Test
//    void should_not_move_under_4() {
//        RacingCar car = new RacingCar();
//        assertThat(car.shouldMove(3)).isFalse();
//        assertThat(car.shouldMove(0)).isFalse();
//    }

    @Order(30)
    @Test
    void move() {
        RacingCar car = new RacingCar();
        assertThat(car.move(5)).isEqualTo(1);
        assertThat(car.move(9)).isEqualTo(2);
    }

    @Order(40)
    @Test
    void not_move() {
        RacingCar car = new RacingCar();
        assertThat(car.move(5)).isEqualTo(1);
        assertThat(car.move(0)).isEqualTo(1);
    }
}
