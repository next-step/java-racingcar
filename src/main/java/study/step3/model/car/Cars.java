package study.step3.model.car;

import study.step3.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> racingGameCars;

    public Cars(int carNumber) {
        this.racingGameCars = new ArrayList<>();
        addCars(carNumber);
    }

    public void move() {
        for (Car car : racingGameCars) {
            int randomNumber = getRandomNumber();
            car.move(randomNumber);
        }
    }

    private void addCars(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            racingGameCars.add(new Car());
        }
    }

    public void printResult() {
        ResultView resultView = new ResultView();
        for (Car car : racingGameCars) {
            resultView.printCarDistance(car);
        }
        System.out.println();
    }

    public List<Car> getRacingGameCars() {
        return racingGameCars;
    }

    private int getRandomNumber() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis() * random.nextInt());
        return random.nextInt(10);
    }
}
