package step3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.common.vo.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeAll
    void setUp() {
        this.car = new Car(0);
    }

    @DisplayName("자동차 생성")
    @Test
    void createCar() {

        assertThat(car.getNumber()).isEqualTo(0);
        assertThat(car.getMoveCount()).isEqualTo(0);

    }

    @DisplayName("자동차 움직이기")
    @Test
    void moveCar() {

        car.move();
        assertThat(car.getMoveCount()).isEqualTo(1);

    }

}
