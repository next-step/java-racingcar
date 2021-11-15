package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final InputView inputView;
    private List<Car> cars;
    private int currentRound;
    private int lastRound;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
        this.currentRound = 0;
    }


    public void play() {
        initGame(inputView.input());
        play(lastRound);
    }
    
    void play(int numberOfTries) {
        while (currentRound < lastRound) {
            cars.forEach(Car::run);
            currentRound += 1;
        }
    }

    void initGame(InputView.InputResult inputResult) {
        cars = new ArrayList<>();

        IntStream.range(0, inputResult.getNumberOfCars())
                .forEach(i -> cars.add(new Car()));
        lastRound = inputResult.getNumberOfTries();
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public int getCurrentRound() {
        return this.currentRound;
    }
}
