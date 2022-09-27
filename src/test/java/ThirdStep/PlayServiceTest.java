package ThirdStep;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.model.GameSetting;
import ThirdStep.services.CarService;
import ThirdStep.services.PlayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayServiceTest {

    private List<Car> cars = new ArrayList<>();
    private final int INIT_ATTEMPTS = 5;
    private final int ZERO = 0;

    private final PlayService play = new PlayService(new CarService());

    @BeforeEach
    void setCars() {
        CarRequest carRequest = new CarRequest("name");
        cars.add(Car.of(carRequest));
        cars.add(Car.of(carRequest));
        cars.add(Car.of(carRequest));
    }


    @Test
    @DisplayName("racing 함수가 종료 시 gameSetting의 attempts 값은 0이다.")
    void racing_test() {
        GameSetting gameSetting = new GameSetting(INIT_ATTEMPTS, cars);

        play.racing(gameSetting);

        assertThat(gameSetting.getAttempts()).isEqualTo(ZERO);
    }
}
