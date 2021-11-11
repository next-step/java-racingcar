package step3;

import step3.manager.RacingManager;
import step3.manager.RandomManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race {
    private RacingCarGroup racingCarGroup;
    private LapsManager lapsManager;
    private Count carCount;
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
        this.lapsManager = new LapsManager(gameBoard.registerTrialCount());
        this.racingCarGroup = new RacingCarGroup(createCarList());
    }

    private List<Car> createCarList() {
        RacingManager racingManager = new RandomManager();

        return IntStream.range(0, carCount.getCount())
                .mapToObj(i -> new Car(racingManager))
                .collect(Collectors.toList());
    }

    private void inGame() {
        gameBoard.renderResultMessage();

        while(!lapsManager.isLastLap()) {
            racingCarGroup.carsRun();

            gameBoard.renderRaceProgress(racingCarGroup);
            lapsManager.finishLap();
        }
    }
}
