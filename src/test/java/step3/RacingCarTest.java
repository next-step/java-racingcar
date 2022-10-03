package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 객체 생성")
    public void 자동차_생성() {
        int carCount = 4;
        ArrayList<Car> cars = ResultView.carMaker(carCount);
        int makedCarsCount = cars.size();
        assertThat(makedCarsCount).isEqualTo(4);
    }

    @Test
    @DisplayName("자동차 전진 - 4 이상일 경우, 1 전진")
    public void 전진() {
        Car car = new Car(1);
        int speed = 4;
        car.move(speed);
        int distance = car.getDistance();
        int movement = distance-1;
        assertThat(movement).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 멈춤 - 4 미만일 경우, 멈춤 = 0 전진")
    public void 멈춤() {
        Car car = new Car(1);
        int speed = 3;
        car.move(speed);
        int distance = car.getDistance();
        int movement = distance-1;
        assertThat(movement).isEqualTo(0);
    }
}
