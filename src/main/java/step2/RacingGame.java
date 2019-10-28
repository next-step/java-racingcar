package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int time;
    private List<Car> cars;
    private ResultView resultView;

    public RacingGame(int time) {
        this.resultView = new ResultView();
        this.time = time;
    }

    public List<Car> carPositionsInitiate(int createCarCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < createCarCount; i++) {
            Car car = new Car(0);
            cars.add(car);
        }

        return cars;
    }

    private int getRandomNumber() {
        return new Random().nextInt(10);
    }

    private int moveCheck() {
        if (getRandomNumber() >= 4) {
            return 1;
        }
        return 0;
    }

    public void execute() {
        for (int i = 0; i < time; i++) {
            move();
        }
    }

    private void move() {
        for (Car car : cars) {
            int position = car.getPosition() + moveCheck();
            car.setPosition(position);
        }
        resultView.printResultView(cars);
    }

}
