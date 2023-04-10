package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step3.Fixture.*;

class CarRacingTest {
    @BeforeEach
    void initCar() {
        carRacing = new CarRacing();
    }

    @Test
    @DisplayName("입력한 자동차 대수 만큼 Car 객체가 생성 되어야한다.")
    void createCarList() {
        int numCar = 3;
        assertThat(carRacing.createCarList(numCar).size()).isEqualTo(numCar);
    }
}