package racingcar.car;

public class NextStepCar implements Car{
    private int position = 0;

    @Override
    public int moveForward() {
        return ++position;
    }

    public int getPosition() {
        return position;
    }
}
