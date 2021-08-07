package race;

public class ResultView {

    protected static void printResult(Cars cars) {
        for (Car car: cars.getCarList()) {
            System.out.println(car.getDistance());
        }
        System.out.println();
    }
}
