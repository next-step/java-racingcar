package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.CarRacing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private final CarRacing carRacing = new CarRacing(3);
    
    @Test
    @DisplayName("자동차들의 이동거리를 저장할 리스트를 만드는 메서드 테스트")
    public void makeCarsListTest() {
        carRacing.makeCarsList(5);
        assertThat(carRacing.getCars()).hasSize(5);
    }

    @Test
    @DisplayName("발생한 랜덤한 값들을 기반으로 자동차들의 전진 여부를 결정하는 메서드 테스트")
    public void isCarMovingForwardTest() {
            assertThat(carRacing.isCarMovingForward()).isIn(true, false);

    }

    @Test
    @DisplayName("각각의 자동차에 대한 전진여부에 따라 실제로 자동차들을 이동시키는 메서드 테스트")
    public void carMoveTest() {
        carRacing.makeCarsList(3);
        List<Car> cars= carRacing.getCars();

        boolean[] carForwardStatuses1 = {true, false, true};

        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(carForwardStatuses1[i]);
        }

        assertThat(cars.get(0).getMovingDistance()).isEqualTo(1);
        assertThat(cars.get(1).getMovingDistance()).isEqualTo(0);
        assertThat(cars.get(2).getMovingDistance()).isEqualTo(1);

        boolean[] carForwardStatuses2 = {false, true, true};

        for(int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(carForwardStatuses2[i]);
        }

        assertThat(cars.get(0).getMovingDistance()).isEqualTo(1);
        assertThat(cars.get(1).getMovingDistance()).isEqualTo(1);
        assertThat(cars.get(2).getMovingDistance()).isEqualTo(2);
    }
}
