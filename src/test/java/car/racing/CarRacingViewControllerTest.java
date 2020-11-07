package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarRacingViewControllerTest {

    private CarRacingViewController viewController;
    private FakeResultView resultView;
    private CarRacingManager manager;

    @BeforeEach
    void setup() {
        resultView = new FakeResultView();
        manager = new CarRacingManager(forward -> true);
        viewController = new CarRacingViewController(resultView, manager);
    }

    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyValidInput() {
        String names = "kyle,tak,lee";
        String[] carNames = names.split(",");
        int tryCount = 7;

        viewController.input(names, tryCount);

        for (int i = 0; i < carNames.length; i++) {
            assertThat(manager.cars.get(i).getName()).isEqualTo(carNames[i]);
        }
        for (int i = 0; i < tryCount; i++) {
            assertThat(resultView.cars.size()).isEqualTo(carNames.length);
        }
        assertThat(resultView.winners.replaceAll("\\s+", "")).isEqualTo(names);
    }

    @DisplayName("input이 제대로 안들어갔을 때 확인")
    @Test
    void verifyInvalidInput() {
        String names = "kyle,tak,leeeeeee";
        int tryCount = 7;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> viewController.input(names, tryCount))
                .withMessageMatching("잘못된 이름 입니다.");
    }
}
