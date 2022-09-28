package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.controller.Game;
import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private static final String NORMAL_NAME1 = "TEST1";
    private static final String NORMAL_NAME2 = "TEST2";
    private static final String NORMAL_NAME3 = "TEST3";


    private List<Car> cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of(NORMAL_NAME1, NORMAL_NAME2, NORMAL_NAME3);
        cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(0, carName);
            cars.add(car);
        }
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 단 한명")
    void getWinner() {
        Game game = new Game();
        Car car = cars.get(0);
        car.goStraight(() -> true);
        List<Car> winner = game.summaryRaceResult(cars);
        assertThat(winner).contains(car);
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 여러명")
    void getWinners() {
        Game game = new Game();
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        Car car3 = cars.get(2);
        car1.goStraight(() -> true);
        car2.goStraight(() -> true);
        car3.goStraight(() -> true);
        List<Car> winner = game.summaryRaceResult(cars);
        assertThat(winner).contains(car1, car2, car3);
    }


}
