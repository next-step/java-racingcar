package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars;

    public RacingGame(String inputName, int trialNum) {
        time = trialNum;
        cars = new ArrayList<>();

        String[] carNames = inputName.split(",");
        int carNum = carNames.length;

        for (int i = 0; i < carNum; i++) {
            cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> doGame() {
        for (int i = 0; i < time; i++) {
            moveWholeCar();
        }
        return cars;
    }

    private void moveWholeCar() {
        for (Car car : cars) {
            car.move();
        }
    }


}
