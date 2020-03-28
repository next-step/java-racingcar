package racingwinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int rounding;
    private List<Car> allCars;
    private List<Car> winners = new ArrayList<>();
    private final int BOUND = 10;
    private final int MOVE_CONDITION = 4;

    public RacingGame(String[] carNames, int rounds) {
        this.rounding = rounds;
        this.allCars = new ArrayList<>(carNames.length);

        for (int idx = 0; idx < carNames.length; idx++) {
            Car racingCar = new Car(carNames[idx]);
            allCars.add(racingCar);
        }
    }

    public void racing() {
        for (int idx = 0; idx < this.rounding; idx++) {
            moveCar();
        }
        winner();
    }

    private void moveCar() {
        for (int carIdx = 0; carIdx < this.allCars.size(); carIdx++) {
            Car nowCar = allCars.get(carIdx);
            isGreaterThan4(nowCar);
        }
        System.out.println();
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }

    public Boolean moveOrNot(int randomNum) {
        return randomNum >= MOVE_CONDITION;
    }

    private void isGreaterThan4(Car nowCar) {
        if (this.moveOrNot(this.getRandomNum())) {
            nowCar.position++;
        }
        ResultView.printResult(nowCar);
    }

    private void winner() {
        int cars = this.allCars.size();
        int max = maxPosition();

        for (int carIdx = 0; carIdx < cars; carIdx++) {
            this.addWinners(allCars.get(carIdx), max);
        }

        ResultView.printWinner(winners);
    }

    private void addWinners(Car resultCar, int max) {
        if(resultCar.position == max) {
            winners.add(resultCar);
        }
    }

    private int maxPosition() {
        int max = allCars.get(0).position;

        for (int idx = 0; idx < allCars.size(); idx++) {
            max = this.findMax(allCars.get(idx).position, max);
        }

        return max;
    }

    public int findMax(int position, int max) {
        if (position > max) {
            return position;
        }
        return max;
    }
}
