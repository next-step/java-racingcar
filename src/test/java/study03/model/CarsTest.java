package study03.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("객체 생성 시 car 객체 수 확인")
    void car갯수() {
        int carCount = 3;
        Cars cars = new Cars(carCount);
        assertThat(cars.getCars().size()).isEqualTo(carCount);
    }
}