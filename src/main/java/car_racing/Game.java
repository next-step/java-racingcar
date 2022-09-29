package car_racing;


import java.util.Objects;
import java.util.stream.IntStream;

public class Game {
    private Integer totalTryCount;
    private Cars cars;
    private OutputInterface outputInterface;

    public Game(Integer totalTryCount, Integer carCount, OutputInterface outputInterface) {
        this.totalTryCount = totalTryCount;
        this.cars = new Cars(carCount);
        this.outputInterface = outputInterface;
    }

    public void play() {
        IntStream.range(0, totalTryCount).forEach(notUsed -> doTry());
    }

    private void doTry() {
        cars.goOrStop();
        cars.straightCounts().forEach(outputInterface::showCurrentStatus);
    }
}