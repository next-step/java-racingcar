package race;

import java.util.List;
import race.domain.Car;
import race.domain.RacingCars;
import race.view.TraceView;

public class RaceRunner {

    private final RacingCars racingCars;
    private final int trial;
    private final TraceView traceView = new TraceView();

    private static final int NO_NAME_LENGTH = 0;
    private static final int MIN_TRIAL = 1;

    public RaceRunner(String[] names, int trial) {
        validate(names.length, trial);
        this.racingCars = new RacingCars(names);
        this.trial = trial;
    }

    public void start() {
        for (int i = 0; i < this.trial; i++) {
            racingCars.race();
            traceView.printMoveResult(racingCars);
            System.out.println();
        }
    }

    public int getTrial() {
        return trial;
    }

    public List<Car> getRacingCars() {
        return this.racingCars.getList();
    }

    private void validate(int length, int trial) {
        if (isLessThanZero(trial)) {
            throw new IllegalArgumentException("1 이상을 입력해 주세요");
        }

        if (isNoNames(length)) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
    }

    private boolean isNoNames(int length) {
        return length == NO_NAME_LENGTH;
    }

    private boolean isLessThanZero(int trial) {
        return trial < MIN_TRIAL;
    }
}
