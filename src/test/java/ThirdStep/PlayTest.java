package ThirdStep;

import ThirdStep.model.Car;
import ThirdStep.model.CarRequest;
import ThirdStep.model.GameSetting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayTest {

    private List<Car> cars = new ArrayList<>();
    private final int INIT_ATTEMPTS = 5;
    private final int ZERO = 0;

    private final Play play = new Play(new CarAction());

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
        GameSetting gameSetting = new GameSetting();
        gameSetting.setAttempts(INIT_ATTEMPTS);
        gameSetting.setCars(cars);

        play.racing(gameSetting);

        assertThat(gameSetting.getAttempts()).isEqualTo(ZERO);
    }
}
