package carracing;

import carracing.domain.Car;
import carracing.domain.Cars;
import carracing.domain.RaceResult;
import carracing.domain.Winners;
import carracing.exception.CarNameFormatException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.")
    void getWinner() throws CarNameFormatException {
        List<Car> carList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Car car = new Car("car" + i);
            car.driving(2 + i);
            carList.add(car);
        }
        Cars cars = new Cars(carList);

        RaceResult raceResult = new RaceResult();
        raceResult.maximumDistance = 1;

        Winners winners = cars.getWinner(raceResult);
        List<String> winnerNames = new ArrayList<>();

        for (Car car : winners.getWinners()) {
            winnerNames.add(car.getName().getAlias());
        }

        Assertions.assertThat(winnerNames).contains("car2", "car3");
    }

    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이다.")
    void getWinnerOnlyOne() throws CarNameFormatException {
        List<Car> carList = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Car car = new Car("car" + i);
            car.driving(1 + i);
            carList.add(car);
        }
        Cars cars = new Cars(carList);

        RaceResult raceResult = new RaceResult();
        raceResult.maximumDistance = 1;

        Winners winners = cars.getWinner(raceResult);
        List<String> winnerNames = new ArrayList<>();

        for (Car car : winners.getWinners()) {
            winnerNames.add(car.getName().getAlias());
        }

        Assertions.assertThat(winnerNames).contains("car3");
    }
}
