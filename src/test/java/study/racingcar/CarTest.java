package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp () {
         car = new Car("luvram");
    }

    @DisplayName("설정한 차의 정보를 체크해본다.")
    @Test
    void checkCarInfo() {
        assertThat(car.getName()).isEqualTo("luvram");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차가 앞으로 잘 가는지 확인한다.")
    @Test
    void checkCarPosition() {
        car.addPosition(2);
        assertThat(car.getPosition()).isEqualTo(2);
    }

}
