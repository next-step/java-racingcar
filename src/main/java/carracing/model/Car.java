package carracing.model;

import carracing.exception.ArgumentOutOfRangeException;
import carracing.model.run.RunStrategy;

public class Car {

    private static final Integer NAME_RANGE_MAXIMUM = 5;

    private String name;
    private RacingHistory racingHistory;

    private Car(String name) {
        this.name = name;
        this.racingHistory = new RacingHistory();
    }

    public static Car from(String carName) {
        validName(carName);
        return new Car(carName);
    }

    public String getName() {
        return this.name;
    }

    public void runRace(RunStrategy runStrategy) {
        racingHistory.addHistory(runStrategy.isRun());
    }

    public Long getSuccessCount() {
        return this.racingHistory.getSuccessCount();
    }

    public Long getSuccessCountByIndex(Integer toIndex) {
        return this.racingHistory.getSuccessCountByIndex(toIndex);
    }

    private static void validName(String carName) {
        if (carName.length() > NAME_RANGE_MAXIMUM) {
            throw new ArgumentOutOfRangeException(NAME_RANGE_MAXIMUM);
        }
    }

}
