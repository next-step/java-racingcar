package ThirdStep;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.model.GameSetting;
import ThirdStep.services.CarService;
import ThirdStep.services.PlayService;
import ThirdStep.services.RecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayServiceTest {

    private List<Car> cars = new ArrayList<>();
    private final int INIT_ATTEMPTS = 5;
    private final int FIRST_RACE = 1;

    private final PlayService play = new PlayService(new RecordService());

    @BeforeEach
    void setCars() {
        CarRequest carRequest = new CarRequest("name");
        cars.add(new Car(carRequest));
        cars.add(new Car(carRequest));
        cars.add(new Car(carRequest));
    }


    @Test
    @DisplayName("racing 함수가 종료 시 gameSetting의 attempts 값은 1이다.")
    void racing_test() {
        GameSetting gameSetting = new GameSetting(INIT_ATTEMPTS, cars);

        play.racing(gameSetting);

        assertThat(gameSetting.getAttempts()).isEqualTo(FIRST_RACE);
    }
}
