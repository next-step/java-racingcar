package racingcar;

public class Car {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    private int position = 1;
    private String name;

    public Car() {
    }

    public Car(final String name) {
        this.name = name;
    }

    public static Car createCar(final String carName) {
        validateCarName(carName);
        return new Car(carName);
    }

    private static void validateCarName(final String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("글자수가 5를 초과했습니다. 다시 입력해주세요.");
        }
    }

    public void move(int number) {
        if (number >= ADVANCE_CONDITION_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
