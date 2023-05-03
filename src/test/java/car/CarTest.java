package car;

import car.domain.Car;
import car.domain.Movable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Random random = new Random();
    private Movable goMove = () -> {return random.nextInt(6)+4;};
    private Movable stopMove = () -> {return random.nextInt(4);};

    List<Car> cars;

    @Test
    @DisplayName("4이상 랜덤값 1 반환 테스트")
    public void test1(){
        Car car = new Car("test1");
        car.move(stopMove);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만 랜덤값 0 반환 테스트")
    public void test2(){
        Car car = new Car("test1");
        car.move(stopMove);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("car 객체 position 상태값 변경테스트")
    public void test3(){
        Car car = new Car("test1");

        int result = 0;
        for (int i = 0; i < 3; i++) {
            car.move(goMove);
            result = car.getPosition();
        }
        assertThat(result).isEqualTo(3);
    }


}
