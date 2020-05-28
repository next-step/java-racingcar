package carracing;

import carracing.domain.RandomValue;
import carracing.domain.car.Car;
import carracing.domain.car.CarRacingGame;
import carracing.domain.car.CarRacingOption;
import carracing.domain.car.Position;
import carracing.domain.RandomMaxValue;
import carracing.domain.RandomMinValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    String[] carNames;
    CarRacingOption carRacingOption;
    CarRacingGame carRacingGame;

    @BeforeEach
    public void init() {
        carNames = new String[]{"car1", "car2", "car3"};
        carRacingOption = new CarRacingOption();
        carRacingGame = new CarRacingGame(carRacingOption);
    }

    @Test
    @DisplayName("Random Value Test")
    public void randomValueTest() {
       assertThat(new RandomValue().getRandomValue()).isBetween(0,9);
    }

    @Test
    @DisplayName("Random Min Value Test")
    public void randomMinValueTest() {
        assertThat(new RandomMinValue().getRandomValue()).isGreaterThan(4);
    }

    @Test
    @DisplayName("Random Max Value Test")
    public void randomMaxValueTest() {
        assertThat(new RandomMaxValue().getRandomValue()).isLessThan(4);
    }

    @Test
    @DisplayName("CarRacing Winner Test")
    public void carRacingWinnerTest() {

        Position car1Position = new Position();
        car1Position.move(5);

        Position car2Position = new Position();
        car2Position.move(4);

        Position car3Position = new Position();
        car3Position.move(8);

        List<Car> carList = new ArrayList<>();

        Car car1 = new Car(carNames[0], "1", car1Position);
        Car car2 = new Car(carNames[1], "2", car2Position);
        Car car3 = new Car(carNames[2], "3", car3Position);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        List<Car> winnerList = carRacingGame.gameWinner(carList);

        assertThat(winnerList.stream().findFirst().get().getName()).isEqualTo("car3");

    }

    @Test
    @DisplayName("CarRacing Winners Test")
    public void carRacingWinnersTest() {

        Position car1Position = new Position();
        car1Position.move(8);

        Position car2Position = new Position();
        car2Position.move(4);

        Position car3Position = new Position();
        car3Position.move(8);

        List<Car> carList = new ArrayList<>();
        List<Car> predictWinnerList = new ArrayList<>();

        Car car1 = new Car(carNames[0], "1", car1Position);
        Car car2 = new Car(carNames[1], "2", car2Position);
        Car car3 = new Car(carNames[2], "3", car3Position);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        predictWinnerList.add(car1);
        predictWinnerList.add(car3);

        List<Car> winnerList = carRacingGame.gameWinner(carList);

        assertThat(winnerList.equals(predictWinnerList)).isTrue();
    }

    @Test
    @DisplayName("CarRacing Test")
    public void carRacingTest() {
        int carCount = 2;
        int gameCount = 2;
        String[] carNames = {"a", "b", "c"};
        CarRacingOption carRacingOption = new CarRacingOption(carNames, carCount, gameCount);
        CarRacingGame carRacingGame = new CarRacingGame(carRacingOption);
        carRacingGame.gameStart();
    }


}
