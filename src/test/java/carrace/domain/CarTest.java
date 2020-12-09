package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("경주차가 전진했을 시 위치가 +1 되는지, 전진하지 않았을 시 그 자리인지 테스트하는 함수")
    void tryMovingForwardTest() {
        Car car = new Car();
        RacingRule racingRule = new FixedRacingRule();

        assertThat(car.getPosition()).isEqualTo(1);

        car.tryToMoveForward(racingRule);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    void carPositionTest() {
        Car car = new Car(1);
        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(car.toString()).isEqualTo("-");

        car = new Car(2);
        assertThat(car.getPosition()).isEqualTo(2);
        assertThat(car.toString()).isEqualTo("--");

        car = new Car(5);
        assertThat(car.getPosition()).isEqualTo(5);
        assertThat(car.toString()).isEqualTo("-----");
    }

}