package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RacingSpec racingSpec;
    private final List<Car> joinCarList = new ArrayList<>();
    private final List<List<Integer>> racingLog = new ArrayList<>();

    public RacingGame(RacingSpec racingSpec) {
        if (racingSpec == null) {
            throw new NullPointerException(ErrorMessage.RACING_SPEC_IS_NULL);
        }
        this.racingSpec = racingSpec;
        initRacingGame();
    }

    private void initRacingGame() {
        for (int i = 0; i < racingSpec.getCarCount(); i++) {
            joinCar();
        }
    }

    public void start() {
        for (int i = 0; i < racingSpec.getMoveCount(); i++) {
            doMoveStep();
        }
    }

    private void doMoveStep() {
        joinCarList
                .stream()
                .forEach(car -> car.move());
        List<Integer> racingResult = getRacingResult();
        saveRacingLog(racingResult);
    }

    private void saveRacingLog(List<Integer> racingResult) {
        racingLog.add(racingResult);
    }

    public List<List<Integer>> getRacingLog() {
        return racingLog;
    }

    private List<Integer> getRacingResult() {
        return joinCarList.stream()
                .map(car -> car.getLocation())
                .collect(Collectors.toList());
    }

    private void joinCar() {
        joinCarList.add(new Car());
    }
}
