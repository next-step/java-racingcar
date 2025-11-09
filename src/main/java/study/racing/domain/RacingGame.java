package study.racing.domain;

import study.racing.view.GameOutput;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int roundCount;
    private final RandomNumber randomNumber;
    private final GameOutput gameOutput;

    public RacingGame(int carCount, int roundCount, RandomNumber randomNumber) {
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.cars.add(new Car());
        }
        this.roundCount = roundCount;
        this.randomNumber = randomNumber;
        this.gameOutput = new GameOutput();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        gameOutput.printResult();
        for (int i = 0; i < roundCount; i++) {
            playRound();
            printCurrentPosition();
            System.out.println("");
        }
    }

    public void playRound() {
        for (Car car : cars) {
            car.move(randomNumber.generate());
        }
    }

    public void printCurrentPosition() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        gameOutput.printRound(positions);
    }


}
