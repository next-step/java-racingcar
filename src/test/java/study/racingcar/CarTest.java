package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("luvram");
    }

    @DisplayName("설정한 차의 정보를 체크해본다.")
    @Test
    void checkCarInfo() {
        assertAll(
                () -> assertEquals("luvram", car.getName()),
                () -> assertEquals(0, car.getPosition())
        );
    }

    @DisplayName("차가 앞으로 잘 가는지 확인한다.")
    @Test
    void checkCarPosition() {
        car.addPosition(2);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("차가 해당하는 위치에 있는지 확인한다.")
    @Test
    void checkCarPositionIsEqualTo() {
        car.addPosition(2);
        assertThat(car.isPositionEqualTo(2)).isTrue();
    }
}
