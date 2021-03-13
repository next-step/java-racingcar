package carRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @Test
    @DisplayName("자동차 인스턴스를 생성할 수 있다")
    void constructorCreatesNewCar() {
        assertThat(car.getScore()).isZero();
        Car updatedCar = new Car(car);
        assertThat(car.getScore()).isZero();
    }

    @Test
    @DisplayName("자동차가 지나간 거리를 구할 수 있다")
    void toStringGetsTraces() {
        for (int iter = 0; iter < 100; iter++) {
            Car updatedCar = car.raceOrStay(car);
            assertThat(updatedCar.getScore() == 0 || updatedCar.getScore() == 1).isTrue();
        }
    }


}