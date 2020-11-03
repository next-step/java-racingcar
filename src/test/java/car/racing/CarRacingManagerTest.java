package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingManagerTest {

    private ResultView resultView;
    private CarRacingManager manager;

    @BeforeEach
    void setup() {
        resultView = new ResultView();
        manager = new CarRacingManager();
    }

    @DisplayName("자동차들이 잘 초기화 되었는지 확인")
    @Test
    void verifySetupCars() {
        int numOfCar = 3;
        manager.setupCars(numOfCar);
        assertThat(manager.cars.size()).isEqualTo(3);
    }

    @DisplayName("전진(혹은 스탑)된 자동차들 리턴")
    @Test
    void verifyForwardEachCar() {
        int numOfCar = 3;

        manager.setupCars(numOfCar);
        manager.forwardEachCar();

        assertThat(manager.cars.size()).isEqualTo(numOfCar);
    }
}
