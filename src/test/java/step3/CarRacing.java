package step3;

public class CarRacing {

    public CarRacing(int carCount) {
        if (carCount < 2 || carCount > 10) {
            throw new RuntimeException();
        }
    }
}
