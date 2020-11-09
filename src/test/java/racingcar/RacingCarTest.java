package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("출력")
    @Test
    void print() {
        CarRace carRace = new CarRace(10, 1);
        ResultView.print(carRace);
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
            car.go(10);
        }
        assertThat(car.getDistance()).isGreaterThan(1);
    }

    @DisplayName("랜덤함수")
    @Test
    void getRandom() {
        CarRace carRace = new CarRace(5, 10);
        assertThat(carRace.getRandom()).isLessThan(10);
    }

}
