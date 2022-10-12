import domain.Car;
import domain.CarName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame = new RacingGame();

    @Test
    public void 자동차_리스트_생성() {
        List<String> carNames = Arrays.asList("sunny", "test", "myCar");
        List<Car> cars = racingGame.makeCars(carNames);
        assertThat(cars.size()).isEqualTo(carNames.size());

        cars.stream().map(car ->
                assertThat(car).isEqualTo(new Car(car.getName()))
        );
    }

    @Test
    public void 자동차_경주_우승자_확인_단독() {
        List<Car> cars = Arrays.asList(new Car(new CarName("sunny")), new Car(new CarName("koo")), new Car(new CarName("rin")));
        cars.get(0).moveWithCondition(1, 0);
        cars.get(0).moveWithCondition(1, 0);
        List<Car> winnerCars = racingGame.getWinners(cars);

        assertThat(winnerCars.size()).isEqualTo(1);
        assertThat(winnerCars.get(0).equals(new Car(new CarName("sunny"))));

    }


    @Test
    public void 자동차_경주_우승자_확인_공동우승() {
        List<Car> cars = Arrays.asList(new Car(new CarName("sunny")), new Car(new CarName("koo")), new Car(new CarName("rin")));
        cars.get(0).moveWithCondition(1, 0);
        cars.get(1).moveWithCondition(1, 0);
        List<Car> winnerCars = racingGame.getWinners(cars);

        assertThat(winnerCars.size()).isEqualTo(2);
        assertThat(winnerCars.get(0).equals(new Car(new CarName("sunny"))));
        assertThat(winnerCars.get(0).equals(new Car(new CarName("koo"))));
    }

}
