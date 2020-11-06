package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingViewControllerTest {

    private CarRacingViewController viewController;
    private FakeResultView resultView;
    private CarRacingManager manager;

    @BeforeEach
    void setup() {
        resultView = new FakeResultView();
        manager = new CarRacingManager();
        viewController = new CarRacingViewController(resultView, manager);
    }

    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyInput() {
        int numOfCar = 3;
        int tryCount = 7;

        viewController.input(numOfCar, tryCount);

        for (int i = 0; i < tryCount; i++) {
            assertThat(resultView.cars.size()).isEqualTo(numOfCar);
        }
    }
}
