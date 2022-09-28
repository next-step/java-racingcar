package racing.controller;

import racing.model.Car;
import racing.strategy.GoStraightStrategy;
import racing.strategy.RandomNumberGoStraightStrategy;
import racing.view.GameInput;
import racing.view.GameOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private GameInput input = new GameInput();
    private GameOutput output = new GameOutput();

    public void play() {
        final String[] carArray = input.getCarArrayBySplit();
        List<Car> cars = this.carSetting(carArray);
        output.printCarCount(cars);

        final int roundCount = input.roundCount();
        output.printRoundCount(roundCount);
        this.playRace(roundCount, cars);
        List<Car> winner = this.summaryRaceResult(cars);
        output.printNoticeWinner(winner);
    }

    public List<Car> carSetting(String[] carArray) {
        List<Car> Cars = new ArrayList<>();
        final int carCount = carArray.length;
        for (int i = 0; i < carCount; i++) {
            String carName = carArray[i];
            Car car = new Car(0, carName);
            Cars.add(car);
        }
        return Cars;
    }

    public void playRace(int roundCount, List<Car> cars) {
        output.printStartRace();
        for (int i = 0; i < roundCount; i++) {
            this.playRound(cars);
            output.printDivideRound();
        }
    }

    public List<Car> summaryRaceResult(List<Car> cars) {
        Collections.sort(cars);
        final int winnerLocation = cars.get(0).getCurrentLocation();
        return getWinner(winnerLocation, cars);
    }

    private void playRound(List<Car> cars) {
        final GoStraightStrategy goStraightStrategy = RandomNumberGoStraightStrategy.getInstance();
        for (Car car : cars) {
            car.goStraight(goStraightStrategy);
            output.printCurrentLocationAndCarName(car);
        }
    }

    private List<Car> getWinner(int winnerLocation, List<Car> cars) {
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (isNotWinnerCar(winnerLocation, car)) return winner;
            winner.add(car);
        }
        return winner;
    }

    private static boolean isNotWinnerCar(int winnerLocation, Car car) {
        return car.getCurrentLocation() < winnerLocation;
    }
}
