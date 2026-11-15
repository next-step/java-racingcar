package step3;

public class CarRacing {

    public CarRacing(int carCount, int tryCount) {
        if (carCount < 2 || carCount > 10) {
            throw new RuntimeException();
        }

        if (tryCount < 1 || tryCount > 10) {
            throw new RuntimeException();
        }
    }
}
