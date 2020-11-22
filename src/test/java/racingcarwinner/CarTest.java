package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 테스트")
    public void move(){
        Car car = new Car("베니");
        Position position0 = new Position(0);
        Position position1 = new Position(1);

        assertThat(car.getPosition()).isEqualTo(position0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(position1);

    }

    @Test
    @DisplayName("자동차 객체를 제대로 생성하는가")
    public void create(){
        Cars cars = Cars.createCars("포비,코난,베니");
        Car car = new Car("코난");
        assertTrue(cars.getCar(1).equals(car));
    }
}
