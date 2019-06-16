package racingcar.model;

public class Car {

    public static final int RUNNING_CONDITION = 4;
    private int position = 1;

    int move(int power) {
        if(isRunning(power)){
            position++;
        }
        return position;
    }

    private boolean isRunning(int power) {
        return RUNNING_CONDITION <= power;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position + '}';
    }
}
