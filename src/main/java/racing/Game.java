package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private GameInput input = new GameInput();

    private GameOutput output = new GameOutput();

    public void play() {
        output.printAskCarCount();
        final int carCount = input.carCount();
        output.printCarCount(carCount);

        List<Car> cars = this.carSetting(carCount);

        output.printAskRoundCount();
        final int roundCount = input.roundCount();
        this.playRace(roundCount, cars);

    }

    private void playRace(int roundCount, List<Car> cars) {
        for (int i = 0; i < roundCount; i++) {
            this.playRound(cars);
        }
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            this.isGoStraight(car);
            output.printCurrentLocation(car);
        }
        output.printDivideRound();
    }

    private void isGoStraight(Car car) {
        car.resetAdvanceCondition();
        if (car.isGoStraight()) {
            car.goStraight();
        }
    }

    private List<Car> carSetting(int carCount) {
        List<Car> Cars = new ArrayList<>();
        for (int i = 1; i <= carCount; i++) {
            Car car = new Car();
            Cars.add(car);
        }
        return Cars;
    }
}
