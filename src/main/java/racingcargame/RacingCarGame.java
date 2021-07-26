package racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private List<RacingCar> cars;
    private int count;

    ResultView resultView = new ResultView();

    RacingCarGame(int numberOfCars, int count) {
        this.cars = createCars(numberOfCars);
        this.count = count;
    }

    private List<RacingCar> createCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new RacingCar());
        }
        return cars;
    }

    public void startGame() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.size(); j++) {
                doRandomCalculation(cars.get(j));
                resultView.showResultView(cars.get(j).getMovingLine());
            }
            System.out.println();
        }
    }

    private void doRandomCalculation(RacingCar racingCar) {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            moveForward(racingCar);
        }
    }

    private void moveForward(RacingCar racingCar) {
        racingCar.move();
    }
}