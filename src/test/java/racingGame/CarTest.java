package racingGame;

import org.junit.Test;
import racingGame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 차가_앞으로_움직인다() {
        Car car = new Car("dicorndl");

        car.moveForward(5);

        assertThat(car.isSamePosition(1)).isTrue();
    }

    @Test
    public void 차가_앞으로_움직이지_못한다() {
        Car car = new Car("dicorndl");

        car.moveForward(3);

        assertThat(car.isSamePosition(0)).isTrue();
    }

    @Test
    public void 자동차_정보_출력_테스트() {
        Car car = new Car("dicorndl", 1);

        assertThat(car.toString()).isEqualTo("dicorndl : -");
    }

    @Test
    public void 자동차_position_순위_비교_테스트() {
        Car car1 = new Car("dicorndl", 3);
        Car car2 = new Car("adcerp2", 1);

        assertThat(car1).isGreaterThan(car2);
    }
}