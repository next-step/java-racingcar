package carracing;

import carracing.exception.CarNameFormatException;
import carracing.util.Car;
import carracing.util.Cars;
import carracing.util.Name;
import carracing.util.RaceResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.")
    void getWinner() throws CarNameFormatException {
        Cars cars = new Cars();

        for (int i = 1; i < 4; i++) {
            Car car = new Car(new Name("car" + i));
            car.driving(2 + i);
            cars.add(car);
        }

        RaceResult raceResult = new RaceResult();
        raceResult.maximumDistance = 1;

        Assertions.assertThat(cars.getWinner(raceResult)).contains("car2", "car3");
    }
}
