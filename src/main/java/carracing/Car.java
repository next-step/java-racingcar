package carracing;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int NAME_LIMIT = 5;

    private String carName;
    private int position;

    Car(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("자동차 이름이 5자 이상입니다");
        }
    }
}
