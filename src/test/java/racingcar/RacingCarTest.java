package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
    }

    @DisplayName("출력")
    @Test
    void print() {
        CarRace carRace = new CarRace(2, 5);
        carRace.race();
        ResultView.print(carRace);
    }

    @DisplayName("차량셋팅")
    @Test
    void initCar() {
        CarRace carRace = new CarRace(2, 5);
        assertThat(carRace.getCars()).hasSize(2);
    }

    @DisplayName("4이상전진")
    @Test
    void carMoveSuccess() {
        car.go(4);
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @DisplayName("10번전진")
    @Test
    void carMove2() {
        for(int i=0; i<10; i++){
            car.go(10);
        }
        assertThat(car.getDistance()).isGreaterThan(10);
    }

    @DisplayName("4미만전진하지않음")
    @Test
    void carMovefail() {
        car.go(3);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("레이스스냅샷확인")
    @Test
    void raceSnapshot() {
        car.go(5);
        assertThat(car.snapshot().getDistance()).isEqualTo(2);
        car.go(5);
        assertThat(car.snapshot().getDistance()).isEqualTo(3);
    }

}
