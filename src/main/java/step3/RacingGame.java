package step3;

import step3.interfaces.OutputInterface;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    // Observable Interfaces
    private OutputInterface outputInterface;
    // Class Members
    private int currentTurn = 0;
    private List<Car> cars;
    private RacingGameConfiguration racingGameConfiguration;

    public RacingGame() {
    }

    public RacingGame(RacingGameConfiguration racingGameConfiguration) {
        this.racingGameConfiguration = racingGameConfiguration;
        this.cars = new CarFactory().createCarsBy(racingGameConfiguration.getNumberOfCars());
    }

    public void attach(OutputInterface output) {
        this.outputInterface = output;
    }

    public void detach() {
        this.outputInterface = null;
    }

    public void send() {
        if (this.outputInterface != null) {
            this.outputInterface.output(this);
        }
    }

    public int getCurrentTurn() {
        return this.currentTurn;
    }

    public List<Car> getCars() {
        return this.cars.subList(0, this.cars.size());
    }

    private void nextTurn() {
        this.cars.forEach(Car::goOrStop);
        this.currentTurn += 1;
    }

    public void startGame() {
        IntStream.range(0, this.racingGameConfiguration.getNumberOfTurns()).forEach(x -> {
            nextTurn();
            send();
        });
    }
}
