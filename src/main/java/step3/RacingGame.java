package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    private final RacingSpec racingSpec;
    private final List<Car> joinCarList = new ArrayList<>();
    private final RacingRecord racingRecord = new RacingRecord();

    public RacingGame(RacingSpec racingSpec) {
        if (racingSpec == null) {
            throw new NullPointerException(ErrorMessage.RACING_SPEC_IS_NULL);
        }
        this.racingSpec = racingSpec;
        initRacingGame();
    }

    private void initRacingGame() {
        IntStream.range(0, racingSpec.getCarCount()).forEach(i -> joinCar());
    }

    public void start() {
        IntStream.range(0, racingSpec.getMoveCount()).forEach(i -> doMoveStep());
    }

    private void doMoveStep() {
        joinCarList
                .stream()
                .forEach(car -> car.move());
        List<Integer> racingResult = getRacingResult();
        racingRecord.saveOneStepRecord(racingResult);
    }

    public List<List<Integer>> getRacingLog() {
        return racingRecord.getRacingRecord();
    }

    private void joinCar() {
        joinCarList.add(new Car());
    }

    private List<Integer> getRacingResult() {
        return joinCarList.stream()
                .map(car -> car.getLocation())
                .collect(Collectors.toList());
    }
}
