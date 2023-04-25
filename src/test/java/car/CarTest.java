package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    List<Car> cars;
    MovementStrategy movementStrategy = new MovementStrategy();

    @Test
    @DisplayName("4이상 랜덤값 1 반환 테스트")
    public void test1(){
        Car car = new Car("test1");
        car.move(movementStrategy.goMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 랜덤값 0 반환 테스트")
    public void test2(){
        Car car = new Car("test1");
        car.move(movementStrategy.stopMoveStrategy());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("car 객체 position 상태값 변경테스트")
    public void test3(){
        Car car = new Car("test1");

        int result = 0;
        for (int i = 0; i < 3; i++) {
            car.move(movementStrategy.goMoveStrategy());
            result = car.getPosition();
        }
        assertThat(result).isEqualTo(3);
    }


}
