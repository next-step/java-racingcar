package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("차동차 객체 생성 테스트")
    public void makeCarMove() {
        Car car = new Car("밤밤");

        car.makeCarMove();
        car.makeCarMove();
        car.makeCarMove();

        assertThat(car.getCarName()).isEqualTo("밤밤");
        assertThat(car.getCarMovedCount()).isGreaterThan(0);
    }
}