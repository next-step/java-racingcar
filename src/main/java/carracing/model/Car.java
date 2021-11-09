package carracing.model;

import carracing.exception.ArgumentOutOfRangeException;
import carracing.util.RandomUtils;

public class Car {

    private static final Integer MIN_FORWARD_NUMBER = 4;

    private static final Integer NAME_RANGE_MAXIMUM = 5;

    private String name;

    private RacingHistory racingHistory;

    public Car(String name) {
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
    
    public void runRace() {
        racingHistory.addHistory(isRun());
    }

    public Long getSuccessCountByIndex(Integer toIndex) {
        return this.racingHistory.getSuccessCountByIndex(toIndex);
    }

    private static void validName(String carName) {
        if(carName.length() > NAME_RANGE_MAXIMUM) {
            throw new ArgumentOutOfRangeException(NAME_RANGE_MAXIMUM);
        }
    }

    private Boolean isRun() {
        return RandomUtils.nextInt() >= MIN_FORWARD_NUMBER;
    }

}
