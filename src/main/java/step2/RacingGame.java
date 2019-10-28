package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int time;
    private List<Car> cars;
    private ResultView resultView;

    public RacingGame() {
        this.resultView = new ResultView();
    }

    public List<Car> carPositionsInitiate(int createCarCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < createCarCount; i++) {
            Car car = new Car(0);
            cars.add(car);
        }

        return cars;
    }

    public int setTime(int time) {
        this.time = time;
        return time;
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public int isMove() {
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

    public void move() {
        for (Car car : cars) {
            int position = car.getPosition() + isMove();
            car.setPosition(position);
        }
        resultView.printResultView(cars);
    }

}
