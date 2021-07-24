package step3;

import step3.enums.MOVE;
import step3.interfaces.OutputInterface;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingGame {
    // Observable Interfaces
    private OutputInterface outputInterface;

    public void attach(OutputInterface output) {
        this.outputInterface = output;
    }

    public void detach() {
        this.outputInterface = null;
    }

    public void send() {
        this.outputInterface.output(this);
    }

    // Class Members
    private int numberOfTurns;
    private int currentTurn = 0;

    private List<Car> cars;

    public RacingGame() {
    }

    public RacingGame(int numberOfCars, int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;

        this.cars = Stream.generate(Car::new)
                .limit(numberOfCars)
                .collect(Collectors.toList());
    }

    public int getCurrentTurn() {
        return this.currentTurn;
    }

    public List<Car> getCars() {
        return this.cars.subList(0, this.cars.size());
    }

    private MOVE goOrStop() {
        return MOVE.fromInt(RandomNumberGenerator.getRandomInt());
    }

    private void nextTurn() {
        this.cars.stream().filter(x -> goOrStop().equals(MOVE.GO))
                .forEach(Car::progress);

        this.currentTurn += 1;
    }

    public void startGame() {
        IntStream.range(0, this.numberOfTurns).forEach(x -> {
            nextTurn();
            send();
        });
    }
}
