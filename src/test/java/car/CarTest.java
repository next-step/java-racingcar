package car;

import car.domain.Car;
import car.domain.impl.GoMoveStrategy;
import car.domain.impl.StopMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    List<Car> cars;


    @Test
    @DisplayName("4이상 랜덤값 1 반환 테스트")
    public void test1(){
        Car car = new Car("test1");
        car.setMovable(new GoMoveStrategy());
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 랜덤값 0 반환 테스트")
    public void test2(){
        Car car = new Car("test1");
        car.setMovable(new StopMoveStrategy());
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("car 객체 position 상태값 변경테스트")
    public void test3(){
        Car car = new Car("test1");

        int result = 0;
        for (int i = 0; i < 3; i++) {
            car.setMovable(new GoMoveStrategy());
            car.move();
            result = car.getPosition();
        }
        assertThat(result).isEqualTo(3);
    }


}
