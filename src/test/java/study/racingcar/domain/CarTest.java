package study.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("luvram", 2);
    }

    @DisplayName("설정한 차의 정보를 체크해본다.")
    @Test
    void checkCarInfo() {
        assertAll(
                () -> assertEquals("luvram", car.getName()),
                () -> assertEquals(2, car.getPosition())
        );
    }

    @DisplayName("현재 위치에 이동할 거리값을 더한 결과를 얻는다.")
    @Test
    void addCarPosition() {
        car.move(2);
        assertThat(car.getPosition()).isEqualTo(4);
    }

    @DisplayName("차가 해당 위치에 있는지 체크한다.")
    @Test
    void checkCarPosition() {
        assertThat(car.isPositionEqualTo(2)).isTrue();
    }
}
