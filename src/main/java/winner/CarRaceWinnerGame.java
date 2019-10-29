package winner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:16
 */
public class CarRaceWinnerGame {

    private static final int FUEL_MAXIMUM = 10;
    private final List<Car> cars;
    private final int gameRound;

    public CarRaceWinnerGame(String[] carNames, int gameRound) {
        this.cars = createCars(carNames);
        this.gameRound = gameRound;
    }

    public void play() {
        for (int round = 0; round < gameRound; round++) {
            moveCar();
        }
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void moveCar() {
        cars.forEach(car -> {
            car.move(RandomValue.getInt(FUEL_MAXIMUM));
            CarRaceResultView.printCurrentCarPosition(car);
        });
        CarRaceResultView.printBlankLine();
    }
}
