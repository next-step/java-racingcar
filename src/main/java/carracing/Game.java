package carracing;


import java.util.stream.IntStream;

public class Game {
    private Integer totalTryCount;
    private Cars cars;
    private OutputInterface outputInterface;

    public Game(Integer totalTryCount, Cars cars, OutputInterface outputInterface) {
        this.totalTryCount = totalTryCount;
        this.cars = cars;
        this.outputInterface = outputInterface;
    }

    public void play() {
        IntStream.range(0, totalTryCount).forEach(notUsed -> doTry());
    }

    private void doTry() {
        cars.goOrStop(new RandomMovableStrategy());
        cars.gatherMoveResults().forEach(outputInterface::showCurrentStatus);
    }
}