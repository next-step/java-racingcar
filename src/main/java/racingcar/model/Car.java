package racingcar.model;

public class Car {

    public static final int RUNNING_CONDITION = 4;
    private int position = 1;

    int move(int power) {
        if(RUNNING_CONDITION <= power){
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" + "position=" + position + '}';
    }
}
