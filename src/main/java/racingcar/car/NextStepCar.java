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
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name length must be lower than 5");
        }
    }
}
