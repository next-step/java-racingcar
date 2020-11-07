package car.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingManagerTest {

    private CarRacingManager manager;

    @BeforeEach
    void setup() {
        manager = new CarRacingManager(forward -> true);
    }

    @DisplayName("자동차들이 잘 초기화 되었는지 확인")
    @Test
    void verifySetupCars() {
        String names = "kyle,tak,lee";
        manager.setupCars(names.split(","));
        assertThat(manager.cars.size()).isEqualTo(3);
    }

    @DisplayName("전진(혹은 스탑)된 자동차들 리턴")
    @Test
    void verifyForwardEachCar() {
        String names = "kyle,tak,lee";
        String[] carNames = names.split(",");
        manager.setupCars(carNames);

        List<Car> cars = manager.forwardEachCar();

        cars.forEach(car -> assertThat(car.getForwardCount()).isEqualTo(1));
    }

    @DisplayName("자동차 경주자 우승자들 이름")
    @Test
    void verifyRacingWinners() {
        String names = "kyle,tak,lee";
        String[] carNames = names.split(",");
        manager.setupCars(carNames);

        List<String> winners = manager.racingWinners();

        assertThat(winners.size()).isEqualTo(3);
    }
}