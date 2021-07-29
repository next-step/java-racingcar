package step5;

import step5.interfaces.OutputInterface;

import java.util.stream.IntStream;

public class RacingGame {
    // Observable Interfaces
    private OutputInterface outputInterface;
    // Class Members
    private int currentTurn = 0;
    private RacingEntry racingEntry;
    private RacingGameConfiguration racingGameConfiguration;

    public RacingGame() {
    }

    public RacingGame(RacingGameConfiguration racingGameConfiguration) {
        this.racingGameConfiguration = racingGameConfiguration;
        this.racingEntry = getRacingEntry(racingGameConfiguration);
    }

    private RacingEntry getRacingEntry(RacingGameConfiguration racingGameConfiguration) {
        return new RacingEntry(CarFactory.createCarsFromNames(racingGameConfiguration.getCarNames()));
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

    public RacingEntry getRacingEntry() {
        return this.racingEntry;
    }

    public RacingGameConfiguration getRacingGameConfiguration() {
        return this.racingGameConfiguration;
    }

    private void nextTurn() {
        this.racingEntry.getCars().forEach(Car::goOrStop);
        this.currentTurn += 1;
    }

    public void startGame() {
        IntStream.range(0, this.racingGameConfiguration.getNumberOfTurns()).forEach(x -> {
            nextTurn();
            send();
        });
    }
}
