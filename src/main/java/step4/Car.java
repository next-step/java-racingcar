package step4;

public class Car {

    private final String carName;

    private final CarEngine carEngine;
    private int movedCount = 0;

    public Car(String carName, CarEngine carEngine) {
        this.carName = checkCarNameLength(carName);
        this.carEngine = carEngine;
    }

    public void move(int randomValue) {
        if (!carEngine.canGo(randomValue)) {
            return;
        }

        this.movedCount++;
    }

    public String getCarName() {
        return carName;
    }

    public int getMovedCount() {
        return movedCount;
    }

    protected String checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자리 초과 할 수 없습니다.");
        }

        return carName;
    }
}
