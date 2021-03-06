package racingcar.car;

public class NextStepCar implements Car {
    private final String name;
    private int position = 0;

    public NextStepCar(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("Car name length must be lower than 5");
        }
        this.name = carName;
    }

    @Override
    public int moveForward(int randomNumber) {
        return (randomNumber >= 4) ? ++position : position;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return name;
    }
}
