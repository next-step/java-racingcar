package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private MovableStrategy movableStrategy = new RandomMovableStrategy();

    @ValueSource(ints = {0})
    @ParameterizedTest
    @DisplayName("차가 움직이면 값이 현재위치와 같거나 이상의 값을 가질 수 있다.")
    void moveTest(int position){

        Car car = new Car(position, movableStrategy);

        int result = car.move();

        assertThat(result).isGreaterThanOrEqualTo(position);
    }

    @ValueSource(ints = {0})
    @ParameterizedTest
    @DisplayName("기본 Car 생성 메소드 테스트")
    void newInstanceTest(int expected){
        Car car = Car.newInstance();

        assertThat(car.getPosition()).isEqualTo(expected);
        assertThat(car.getMovableStrategy()).isExactlyInstanceOf(RandomMovableStrategy.class);
    }
}
