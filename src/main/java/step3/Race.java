package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Race {
    private final int TEN = 10;
    private List<Car> carList;
    private Count carCount;
    private Count trialCount;
    private GameBoard gameBoard;

    public Race() {
        gameBoard = new GameBoard();
    }

    public void start() {
        ready();

        inGame();
    }

    private void ready() {
        this.carCount = gameBoard.registerCar();
        this.trialCount = gameBoard.registerTrialCount();

        this.carList = new ArrayList<>();
        this.carList.addAll(createCarList());
    }

    private List<Car> createCarList() {
        Car[] car = new Car[this.carCount.getCount()];

        for(int i = 0 ; i < car.length ; ++i) {
            car[i] = new Car();
        }
        return Arrays.asList(car);
    }

    private void inGame() {
        gameBoard.renderResultMessage();

        int trialCount = this.trialCount.getCount();

        for(int t = 0; t < trialCount; ++t) {
            racing();
        }
    }

    private void racing() {
        carList.stream()
                .forEach(c -> {
                    c.run(randomCount());
                    gameBoard.renderRaceProgress(c.currentPosition());
                });

        System.out.println();
    }

    private int randomCount() {
        return (int)(Math.random() * TEN);
    }
}
