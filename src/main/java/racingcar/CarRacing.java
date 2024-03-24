package racingcar;

import java.util.*;

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
        printGameResult(gameResult());
    }

    private void run() {
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        if(car.getLocation() == 0){
            car.move(1);
            return;
        }

        int condition = random.nextInt(10);
        if (condition >= 4) {
            car.move(1);
        }
    }

    private List<String> gameResult() {
        int max = 0;
        for (int i = 0; i < cars.size(); i++) {
            max = getMaxLocation(i, max);
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            checkWinner(i, max, winners);
        }

        return winners;
    }

    private void checkWinner(int i, int max, List<String> winners) {
        if (cars.get(i).getLocation() == max) {
            winners.add(cars.get(i).getName());
        }
    }

    private int getMaxLocation(int i, int max) {
        if (cars.get(i).getLocation() > max) {
            max = cars.get(i).getLocation();
        }
        return max;
    }

}
