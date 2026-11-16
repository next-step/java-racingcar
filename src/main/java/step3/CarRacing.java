package step3;

public class CarRacing {

    private int tryCount;

    public CarRacing(int carCount, int tryCount) {
        if (carCount < 2 || carCount > 10) {
            throw new RuntimeException();
        }

        if (tryCount < 1 || tryCount > 10) {
            throw new RuntimeException();
        }

        this.tryCount = tryCount;
    }

    public void tryRace() {
        if (tryCount < 1) {
            throw new RuntimeException();
        }

        tryCount--;
    }
}
