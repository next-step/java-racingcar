package autoracing;

public class Car {
    private int mileage;

    public Car() {
    }

    public int getMileage() {
        return mileage;
    }

    public boolean canGoForward(int randomValue) {
        return randomValue >= 4;
    }

    public int race(int randomValue) {
        if (canGoForward(randomValue)) {
            mileage++;
        }
        return mileage;
    }
}
