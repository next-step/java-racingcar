package racingcar;

public class Car {

    private static final int MIN_MOVING_CONDITION = 4;
    private static final int POSITION_MOVE = 1;

    private String name;
    private int currentPosition = 0;

    private Car(String name) {
        this.name = name;
    }

    private Car(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public static Car carDtoMapper(CarDto carDto) {
        return new Car(carDto.getName(), carDto.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(int randomValue) {
        if(checkMovable(randomValue)) {
            this.currentPosition += POSITION_MOVE;
        }
    }

    private boolean checkMovable(int randomValue) {
        return randomValue >= MIN_MOVING_CONDITION;
    }

}
