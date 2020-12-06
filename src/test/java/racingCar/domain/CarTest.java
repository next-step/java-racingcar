package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private String carName = "louis";
    private Car car;
    private Car compareCar1;
    private Car compareCar2;

    @BeforeEach
    void setUp() {
         car = new Car(carName);
         compareCar1 = new Car("test1");
         compareCar2 = new Car("test2");
    }

    @Test
    @DisplayName("자동차 전진 test")
    void goCar() {
        car.racing(4, new RandomMoveStrategy());
        assertThat(car.getPosition().getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 멈춤 test")
    void stopCar() {
        car.racing(2, new RandomMoveStrategy());
        assertThat(car.getPosition().getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 3회 이동 test")
    void moveCar() {
        car.racing(4, new RandomMoveStrategy());
        car.racing(2, new RandomMoveStrategy());
        car.racing(7, new RandomMoveStrategy());
        assertThat(car.getPosition().getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 위치 toString")
    void drawPosition() {
        car.racing(4, new RandomMoveStrategy());
        car.racing(2, new RandomMoveStrategy());
        car.racing(7, new RandomMoveStrategy());
        assertThat(car.toString()).isEqualTo("louis : --");
    }

    @Test
    @DisplayName("자동차 이름 Test")
    void carName() {
        assertThat(car.getName()).isEqualTo("louis");
    }

    @Test
    @DisplayName("자동차 비교 test(기준 > 비교 : return 1)")
    void returnOne() {
        compareCar1.racing(4, new RandomMoveStrategy());
        compareCar1.racing(7, new RandomMoveStrategy());
        compareCar2.racing(2, new RandomMoveStrategy());
        assertThat(compareCar1.compareTo(compareCar2)).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 비교 test(기준 = 비교 : return 0)")
    void returnZero() {
        compareCar1.racing(4, new RandomMoveStrategy());
        compareCar2.racing(7, new RandomMoveStrategy());
        assertThat(compareCar1.compareTo(compareCar2)).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 비교 test(기준 < 비교 : return -1)")
    void returnMinusOne() {
        compareCar2.racing(4, new RandomMoveStrategy());
        compareCar2.racing(7, new RandomMoveStrategy());
        compareCar1.racing(2, new RandomMoveStrategy());
        assertThat(compareCar1.compareTo(compareCar2)).isEqualTo(-1);
    }
}
