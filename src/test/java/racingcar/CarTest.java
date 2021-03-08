package racingcar;

import racingcar.model.Car;
import racingcar.model.action.RandomMovable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성")
    public void makeCar() {
        assertThatCode(() -> new Car())
                .doesNotThrowAnyException();
    }


    @Test
    @DisplayName("자동차 전진")
    public void moveCar() {
        Car car = new Car();
        car.move();
        assertEquals(1,car.getPoisition());
    }

    @Test
    @DisplayName("랜덤값이 4 이상일 경우 자동차 전진")
    public void moveCarWithRandomValueMoreThenFour() {
        Car car = new Car();
        RandomMovable movable = new RandomMovable();
        if (movable.moveOrNot(4)) {
            car.move();
        }
        assertEquals(1,car.getPoisition());

    }

    @Test
    @DisplayName("랜덤값이 4 미만일 경우 자동차 멈춤")
    public void moveCarWithRandomValueLessThenFour() {
        Car car = new Car();
        RandomMovable movable = new RandomMovable();
        if (movable.moveOrNot(3)) {
            car.move();
        }
        assertEquals(0,car.getPoisition());
    }


}
