package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.CarRace;
import racingcar.InputView;
import racingcar.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("출력")
    @Test
    void print() {
        Car car = new Car();
        ResultView.print(car);
    }

    @DisplayName("차량셋팅")
    @Test
    void initCar() {
        CarRace carRace = new CarRace(10, 1);
        assertThat(carRace.getCarList()).hasSize(10);
    }

    @DisplayName("레이스테스트")
    @Test
    void carMove() {
        Car car = new Car();
        for(int i=0; i<10; i++){
            car.go();
        }
        assertThat(car.getDistance()).isGreaterThan(1);
    }

    @DisplayName("랜덤함수")
    @Test
    void getRandom() {
        Car car = new Car();
        assertThat(car.getRandom()).isLessThan(10);
    }

}
