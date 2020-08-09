package racingcar.model;

public class RacingCar implements Comparable<RacingCar> {

    private static final String racingCarNamePattern = "^[a-zA-Z0-9]{1,6}$";
    private String carName;
    private int carPosition;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public RacingCar(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public RacingCar run(Rule racingRule) {
        if(racingRule.checkRule()) {
            carPosition++;
        }
        return new RacingCar(this.carName, this.carPosition);
    }

    public Integer getCarPosition() {
        return carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public static boolean validateCarName(String racingCarName) {
        return racingCarName.matches(racingCarNamePattern);
    }

    public boolean isSamePosition(RacingCar other) {
        return other.getCarPosition() == this.carPosition;
    }

    @Override
    public int compareTo(RacingCar other) {
        return this.carPosition - other.getCarPosition();
    }
}
