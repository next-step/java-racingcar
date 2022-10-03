package racing.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.view.GameOutput;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    private static final String NORMAL_NAME1 = "TEST1";
    private static final String NORMAL_NAME2 = "TEST2";
    private static final String NORMAL_NAME3 = "TEST3";
    private static final int EXPECT_WINNER_SIZE = 3;
    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of(NORMAL_NAME1, NORMAL_NAME2, NORMAL_NAME3);
        cars = new Cars(carNames.stream()
                .map(it -> new Car(0, it))
                .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 단 한명")
    void getWinner() {
        this.goStraightCarByName(NORMAL_NAME1);

        Cars winner = cars.getWinner();
        assertThat(GameOutput.getNameInCars(winner.getCarList())).isEqualTo(NORMAL_NAME1);
    }

    @Test
    @DisplayName("레이스 우승자 찾기 Test 우승자는 여러명")
    void getWinners() {
        for (Car car : cars.getCarList()) {
            car.goStraight(() -> true);
        }
        Cars winner = cars.getWinner();
        int winnerSize = winner.getCarList().size();
        assertThat(winnerSize).isEqualTo(EXPECT_WINNER_SIZE);
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