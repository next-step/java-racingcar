package step4;

public class Car {

    private static final int LIMIT_NAME_LENGTH = 5;
    private final String name;

    private final CarEngine carEngine;
    private int movedCount = 0;

    public Car(String carName, CarEngine carEngine) {
        checkNameLength(carName);
        this.name = carName;
        this.carEngine = carEngine;
    }

    public void move(int randomValue) {
        if (!carEngine.canGo(randomValue)) {
            return;
        }

        this.movedCount++;
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }

    protected void checkNameLength(String carName) {
        if (carName.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자리 초과 할 수 없습니다.");
        }
    }
}
