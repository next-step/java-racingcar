package car.racing;

import car.racing.domain.Car;
import car.racing.domain.CarRacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {

    private CarRacingGame manager;

    @DisplayName("자동차들이 잘 초기화 되었는지 확인")
    @Test
    void verifySetupCars() {
        String[] carNames = "pobi,crong,honux".split(",");

        manager = new CarRacingGame(getCars(carNames), forward -> true);

        List<Car> cars = manager.getCars();
        IntStream.range(0, cars.size())
                .forEach(i -> assertThat(cars.get(i).getName()).isEqualTo(carNames[i]));
    }

    @DisplayName("각 시도마다 전진 테스트가 잘되었는지 확인")
    @Test
    void verifyForwardCarEachTry() {
        String[] carNames = "pobi,crong,honux".split(",");
        manager = new CarRacingGame(getCars(carNames), forward -> true);
        manager.forwardCarEachTry();

        List<Car> cars = manager.getCars();
        cars.forEach(car -> assertThat(car.getForwardCount()).isEqualTo(1));
    }

    private List<Car> getCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }
}