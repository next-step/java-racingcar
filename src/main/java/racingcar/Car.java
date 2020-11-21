package racingcar;

public class Car {
    private int location;
    private final String name;

    private final static int MAX_NAME_LENGTH = 5;
    private final static int MOVE_POINT = 4;
    private final static int START_LOCATION = 1;

    public Car(String name) {
        this.location = START_LOCATION;
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
       if (name.length() > MAX_NAME_LENGTH)
           throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH +"자 이하로 입력해주세요 :)");
    }

    public static Car newCar(String name) {
        return new Car(name);
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    private void move() {
        location++;
    }

    public void tryToMove(int randomNumber) {
        if (randomNumber >= MOVE_POINT) {
            move();
        }
    }
}
