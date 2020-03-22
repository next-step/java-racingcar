package racingcar.model;

public class Car {
    private static final int MINIMUM_NUMBER_TO_RUN = 4;
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean canRun(int randomNum) {
        return randomNum >= MINIMUM_NUMBER_TO_RUN;
    }

    public void move(boolean canRun) {
        if (canRun) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}