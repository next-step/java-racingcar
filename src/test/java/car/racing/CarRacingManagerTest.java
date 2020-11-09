package car.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingManagerTest {

    private CarRacingManager manager;
    private String names = "pobi,crong,honux";
    private String[] carNames = names.split(",");
    private List<Car> cars = Arrays.stream(carNames)
            .map(name -> new Car(name, 0))
            .collect(Collectors.toList());

    @DisplayName("자동차들이 잘 초기화 되었는지 확인")
    @Test
    void verifySetupCars() {
        manager = new CarRacingManager(cars, forward -> true);
        List<Car> cars = manager.getCars();
        IntStream.range(0, cars.size())
                .forEach(i -> assertThat(cars.get(i).getName()).isEqualTo(carNames[i]));
    }

    @DisplayName("각 시도마다 전진 테스트가 잘되었는지 확인")
    @Test
    void verifyForwardCarEachTry() {
        manager = new CarRacingManager(cars, forward -> true);
        manager.forwardCarEachTry();

        List<Car> cars = manager.getCars();
        cars.forEach(car -> assertThat(car.getForwardCount()).isEqualTo(1));
    }

    @DisplayName("자동차 경주자 우승자들 이름")
    @Test
    void verifyRacingWinners() {
        List<Car> cars = Arrays.asList(
                new Car("pobi", 2),
                new Car("crong", 1),
                new Car("honux", 2));
        manager = new CarRacingManager(cars, forward -> true);

        List<String> winners = manager.racingWinners();

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0)).isEqualTo("pobi");
        assertThat(winners.get(1)).isEqualTo("honux");
    }
}