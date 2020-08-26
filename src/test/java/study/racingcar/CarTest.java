package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;
    private String NAME = "pobi";

    @BeforeEach
    void setup() {
        car = new Car(NAME);
    }

    @Test
    @DisplayName("차 이름 가져오는지")
    void isCarNameCorrect() {
        assertThat(car.getName()).isEqualTo(NAME);
    }

    @Test
    @DisplayName("차 이동 여부 가져오는지")
    void isCarGetPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차 이동 했는지")
    void isCarMove() {
        car.move();
        assertEquals(1, car.getPosition());
    }

}
