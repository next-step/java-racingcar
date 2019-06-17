package racingcar.model;

public class Car {

    public static final int RUNNING_CONDITION = 4;
    public static final int DEFAULT_POSITION = 1;
    private int position;

    private Car(int position) {
        this.position = position;
    }

    public static Car create(){
        return new Car(DEFAULT_POSITION);
    }

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
