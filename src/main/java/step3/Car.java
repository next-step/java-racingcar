package step3;

public class Car {

    private CarEngine carEngine;
    private int movedCount = 0;

    public Car(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public void move(int randomValue) {
        if (!carEngine.canGo(randomValue)) {
            return;
        }

        this.movedCount++;
    }

    public int getMovedCount() {
        return movedCount;
    }
}
