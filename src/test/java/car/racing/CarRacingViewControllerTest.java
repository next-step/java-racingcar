package car.racing;

import car.racing.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingViewControllerTest {

    private CarRacingViewController viewController;
    private FakeResultView resultView;
    private CarRacingManager manager;
    private String names = "pobi,crong,honux";
    private String[] carNames = names.split(",");
    private List<Car> cars = Arrays.stream(carNames)
            .map(name -> new Car(name, 0))
            .collect(Collectors.toList());

    @BeforeEach
    void setup() {
        resultView = new FakeResultView();
        manager = new CarRacingManager(cars, forward -> true);
        viewController = new CarRacingViewController(resultView, manager);
    }

    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyValidInput() {
        int tryCount = 5;

        viewController.input(tryCount);

        assertThat(resultView.cars.size()).isEqualTo(carNames.length * tryCount);
    }
}
