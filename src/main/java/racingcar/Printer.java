package racingcar;

public class Printer {
    private static void print(int count) {
        for (int print = 0; print < count; print++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void println(String printable) {
        System.out.println(printable);
    }

    private static void print(String printable) {
        System.out.print(printable);
    }

    public static void print(RacingCars cars) {
        for (RacingCar car : cars.getCars()) {
            print(car.getName() + " : ");
            print(car.getMovement());
        }
    }
}
