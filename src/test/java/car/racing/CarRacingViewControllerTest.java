package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingViewControllerTest {

    private CarRacingViewController viewController;
    private ResultView resultView;
    private CarRacingManager manager;

    @BeforeEach
    void setup() {
        resultView = new ResultView();
        manager = new CarRacingManager();
        viewController = new CarRacingViewController(resultView, manager);
    }

    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyInput() {
        int numOfCar = 3;
        int tryCount = 7;

        viewController.input(numOfCar, tryCount);

        assertThat(manager.forwardEachCar().size()).isEqualTo(3);
    }
}
