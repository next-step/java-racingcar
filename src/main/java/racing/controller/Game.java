package racing.controller;

import racing.model.Car;
import racing.strategy.GoStraightStrategy;
import racing.strategy.RandomNumberGoStraightStrategy;
import racing.view.GameInput;
import racing.view.GameOutput;

import java.util.ArrayList;
import java.util.List;

public class Game {


    private GameInput input = new GameInput();
    private GameOutput output = new GameOutput();

    public void play() {
        final int carCount = input.carCount();
        output.printCarCount(carCount);

        List<Car> cars = this.carSetting(carCount);

        final int roundCount = input.roundCount();
        output.printRoundCount(roundCount);
        this.playRace(roundCount, cars);
    }

    private List<Car> carSetting(int carCount) {
        List<Car> Cars = new ArrayList<>();
        for (int i = 1; i <= carCount; i++) {
            Car car = new Car(0);
            Cars.add(car);
        }
        return Cars;
    }

    private void playRace(int roundCount, List<Car> cars) {
        for (int i = 0; i < roundCount; i++) {
            this.playRound(cars);
        }
    }

    private void playRound(List<Car> cars) {
        final GoStraightStrategy goStraightStrategy = RandomNumberGoStraightStrategy.getInstance();
        for (Car car : cars) {
            car.goStraight(goStraightStrategy);
            output.printCurrentLocation(car);
        }
        output.printDivideRound();
    }
}
