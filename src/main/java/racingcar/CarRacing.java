package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racingcar.view.ResultView.printResult;

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
            printResult(cars);
            run();
        }
    }

    private void run() {
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        int condition = random.nextInt(10);
        if (condition >= 4) {
            car.move(1);
        }
    }
}
