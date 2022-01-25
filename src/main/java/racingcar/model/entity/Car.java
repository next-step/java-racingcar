package racingcar.model.entity;

public class Car {

    private final String name;
    private final static int NUMBER_ZERO = 0;
    private final static String DELIMITER = " ";
    private int step;

    private Car(final String name) {
        this.name = name;
        this.step = NUMBER_ZERO;
    }

    public static Car get(final String name) {
        return new Car(name);
    }

    public void moveForward() {
        this.step++;
    }

    public int getStep() {
        return step;
    }

    public String getName() {
        return name;
    }

    public StringBuilder maxCheck(int max, StringBuilder playRacingResult) {
        if (max == getStep()) {
            return playRacingResult.append(getName() + DELIMITER);
        }
        return playRacingResult;
    }

    public String toString(int max) {
        StringBuilder playRacingResult = new StringBuilder();
        maxCheck(max, playRacingResult);
        return playRacingResult.toString();
    }
}

