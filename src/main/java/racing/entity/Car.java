package racing.entity;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private int position = 1;
    private String carName;

    public Car() {
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    public void move() {
        position++;
    }

    public void registerName(String carName) {
        if (checkNameLength(carName)) {
            this.carName = carName;
        }
    }

    private boolean checkNameLength(String carName) {
        int carNameLength = carName.length();

        if (carNameLength > MAX_NAME_LENGTH) {
            String messageFormat = "자동차 이름은 5자 이하여야 합니다. 입력값 : %s(%d자)";
            throw new IllegalArgumentException(String.format(messageFormat, carName, carNameLength));
        }

        return true;
    }
}
