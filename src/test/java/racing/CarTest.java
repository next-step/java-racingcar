package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("시작점이 음수인 자동차는 생성할 수 없다")
    void validateCar(){
        assertThatThrownBy(()->{
            new Car(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("현재 자동차 위치")
    void currentPosition(int carPosition){
        Car car = new Car(carPosition);
        assertThat(car.currentPosition()).isEqualTo(carPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    @DisplayName("자동차의 위치가 앞으로 이동")
    void moveForward(int carPosition){
        Car car = new Car(carPosition);
        car.moveForward();
        assertThat(car.currentPosition()).isEqualTo(++carPosition);
    }

}