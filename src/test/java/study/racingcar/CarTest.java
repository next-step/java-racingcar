package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("차 전진")
    void isCarMove() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차 정지")
    void isCarStop() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
