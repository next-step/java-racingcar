package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Car carA;
    Car carB;
    Car carC;

    @BeforeEach
    void setup() {
        carA = new Car(() -> true, "a");
        carB = new Car(() -> true, "b");
        carC = new Car(() -> false, "c");
    }

    @DisplayName("전략에 따른 전체 이동")
    @Test
    void moveAll() {
        Cars cars = new Cars(Arrays.asList(carA, carB, carC));

        cars.moveAll();
        assertThat(carA.getPosition()).isEqualTo(1);
        assertThat(carB.getPosition()).isEqualTo(1);
        assertThat(carC.getPosition()).isEqualTo(0);
    }

    @DisplayName("position이 가장 큰 차량 리스트 리턴")
    @Test
    void findWinners() {
        Cars cars = new Cars(Arrays.asList(carA, carB, carC));

        cars.moveAll();
        List<Car> winners = cars.findWinners();
        assertThat(winners.contains(carA)).isTrue();
        assertThat(winners.contains(carB)).isTrue();
        assertThat(winners.contains(carC)).isFalse();
    }
}