package study.racingCar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.beans.Transient;

import static org.assertj.core.api.Assertions.assertThat;
import static study.racingCar.StringToIntConverter.stringToIntConverter;

class RacingModelTest {

    @Test
    void carPositionTest(){
        Car car = new Car(3);
        assertThat(car.position).isEqualTo(3);
    }

    @Test
    void 전진() {
        assertThat(RacingModel.roundRun(4)).isTrue();
    }

    @Test
    void 멈춤() {
        assertThat(RacingModel.roundRun(3)).isFalse();
    }

    @Test
    void gameTest(){
        Car car = new Car();
        assertThat(car.carAddPosition(true)).isEqualTo(1);
    }

}