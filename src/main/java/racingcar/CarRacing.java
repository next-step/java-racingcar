package racingcar;

import java.util.*;

import static racingcar.Winners.getWinners;
import static racingcar.view.ResultView.printGameResult;
import static racingcar.view.ResultView.printRoundResult;

public class CarRacing {

    private int times;
    private List<Car> cars;
    private Random random;

    public CarRacing(int times, String inputNames) throws Exception {
        this.times = times;
        this.cars = new ArrayList<>();
        grantCarName(inputNames);
        random = new Random();
    }

    private void grantCarName(String inputNames) throws Exception {
        String[] carNames = inputNames.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playGame() {
        for (int i = 0; i < times; i++) {
            run();
            printRoundResult(cars);
        }
        printGameResult(getWinners(cars));
    }

    private void run() {
        for (Car car : cars) {
            int condition = random.nextInt(10);
            car.move(condition);
        }
    }

}
