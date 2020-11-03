package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {

    private CarRacingViewController viewController;
    private ResultView resultView;
    private CarRacingManager manager;

    @BeforeEach
    void setup() {
        resultView = new ResultView();
        manager = new CarRacingManager();
        viewController = new CarRacingViewController(resultView, manager);
    }

    /**
     * CarRacingViewController test
     */
    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyInput() {
        int numOfCar = 3;
        int tryCount = 7;

        viewController.input(numOfCar, tryCount);

        assertThat(manager.forwardEachCar().size()).isEqualTo(3);
    }

    /**
     * CarRacingManager test
     */
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

    /**
     * Car test
     */
    @DisplayName("자동차 전진 테스트")
    @Test
    void verifyCarForward() {
        Car car = new Car(() -> true);
        car.forwardOrNot();
        assertThat(car.forwardResult()).isEqualTo("-");
    }

    @DisplayName("자동차 스탑 테스트")
    @Test
    void verifyCarStop() {
        Car car = new Car(() -> false);
        car.forwardOrNot();
        assertThat(car.forwardResult()).isEqualTo("");
    }
}
