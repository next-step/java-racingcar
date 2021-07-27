package racingcargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    private List<RacingCar> cars;
    private int count;

    private ResultView resultView = new ResultView();
    private Random random = new Random();

    private List<RacingCar> createCars(int numberOfCars) {
        List<RacingCar> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new RacingCar());
        }
        return cars;
    }

    public void startGame(int car, int count) {
        cars = createCars(car);
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < car; j++) {
                resultView.showResultView((cars.get(j).doRandomCalculation(random.nextInt(10))));
            }
            System.out.println();
        }
    }
}