package step2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Car;
import step2.model.RacingWinner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {

    private List<Car> cars;

    @BeforeEach
    void init() {
        cars = new ArrayList<>();
        String[] carNameArray = new String[]{"feelydh", "dhlee", "jwlee"};
        int[] carPositionArray = new int[]{0, 4, 4};

        Car car;
        String carName;
        int carPosition;
        int carNumber = carNameArray.length;
        for (int i = 0; i < carNumber; i++) {
            carName = carNameArray[i];
            carPosition = carPositionArray[i];
            car = new Car(carName);
            car.carPositionUpdate(1);
            car.carPositionUpdate(carPosition);
            cars.add(car);
        }
    }

    @Test
    @DisplayName("우승자 이름 정보 가져오는 테스트")
    void racingWinnerTest() {
        RacingWinner winnerResult = new RacingWinner(cars);
        String winners = winnerResult.maxPostionCarName();
        assertThat(winners).isEqualTo("dhlee, jwlee");
    }

    @Test
    @DisplayName("가장 높은 position 정보 가져오는 테스트")
    void maxPostionTest() {
        RacingWinner winnerResult = new RacingWinner(cars);
        int maxPostion = winnerResult.maxPosition();
        assertThat(maxPostion).isEqualTo(2);
    }

}