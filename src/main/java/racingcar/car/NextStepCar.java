package racingcar.car;

public class NextStepCar implements Car{
    private int position = 0;

    @Override
    public int moveForward(int randomNumber) {
        return (randomNumber >= 4) ? ++position : position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public void setName(String carName) {

    }
}
