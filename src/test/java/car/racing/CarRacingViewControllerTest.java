package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingViewControllerTest {

    private CarRacingViewController viewController;
    private FakeResultView resultView;
    private CarRacingManager manager;
    private String[] names = "pobi,crong,honux".split(",");

    @BeforeEach
    void setup() {
        resultView = new FakeResultView();
        manager = new CarRacingManager(names, forward -> true);
        viewController = new CarRacingViewController(resultView, manager);
    }

    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyValidInput() {
        int tryCount = 5;

        viewController.input(tryCount);

        assertThat(resultView.cars.size()).isEqualTo(names.length * tryCount);
    }
}
