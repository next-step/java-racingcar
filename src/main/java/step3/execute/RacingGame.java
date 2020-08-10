package step3.execute;

import step3.model.Car;
import step3.strategy.MovementStrategy;
import step3.strategy.RacingGameMovementStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {
    private List<Car> challengerList;
    private List<Integer> scoreSet;
    private List<List<Integer>> scoreBoard;
    private int trialCounts;
    private int numberOfCars;

    public RacingGame(int counts, int trials) {
        this.numberOfCars = counts;
        this.trialCounts = trials;
    }

    public void initializeGameVariable(int numberOfCars) {
        this.challengerList = Stream.generate(() -> new Car(1, new RacingGameMovementStrategy()))
                .limit(numberOfCars)
                .collect(Collectors.toList())
        ;
        this.scoreBoard = new ArrayList<>();
    }

    public List<Integer> playGame() {
        // For문으로 구성된 내용을 Stream으로 모두 변경 진행
        for (Car car : challengerList) {
            MovementStrategy tmpStrategy = new RacingGameMovementStrategy();
            car.accelerateCar(tmpStrategy);
        }
        return writeGameRecord();
    }

    public List<Integer> writeGameRecord() {
        scoreSet = new ArrayList<>();
        for (int loop = 0; loop < this.numberOfCars; loop++) {
            scoreSet.add(challengerList.get(loop).showDistance());
        }
        return scoreSet;
    }

    public List<List<Integer>> run() {
        // Game에서 사용하는 변수 초기화
        initializeGameVariable(this.numberOfCars);
        for (int loop = 0; loop < this.trialCounts; loop++) {
            scoreBoard.add(playGame());
        }
        return scoreBoard;
    }
}
