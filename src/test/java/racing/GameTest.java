package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.controller.Game;
import racing.model.Car;
import racing.model.Cars;
import racing.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    private static final String NORMAL_NAME1 = "TEST1";
    private static final String NORMAL_NAME2 = "TEST2";
    private static final String NORMAL_NAME3 = "TEST3";
    private static final String COMMA = ",";


    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of(NORMAL_NAME1, NORMAL_NAME2, NORMAL_NAME3);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(0, carName);
            carList.add(car);
        }
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 단 한명")
    void getWinner() {
        Game game = new Game();
        this.goStraightCarByName(NORMAL_NAME1);

        Cars winner = game.summaryRaceResult(cars);
        assertThat(StringUtil.getNameInCarList(winner.getCarList())).isEqualTo(NORMAL_NAME1);
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 여러명")
    void getWinners() {
        Game game = new Game();
        for (Car car : cars.getCarList()) {
            car.goStraight(() -> true);
        }
        Cars winner = game.summaryRaceResult(cars);
        assertThat(StringUtil.getNameInCarList(winner.getCarList())).contains(
                NORMAL_NAME1 + COMMA + NORMAL_NAME2 + COMMA + NORMAL_NAME3
        );
    }

    private void goStraightCarByName(String name) {
        for (Car car : cars.getCarList()) {
            if (isSameCarByName(name, car)) {
                car.goStraight(() -> true);
            }
        }
    }

    private boolean isSameCarByName(String name, Car car) {
        return name.equals(car.getName());
    }


}
