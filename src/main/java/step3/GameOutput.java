package step3;

public class GameOutput {

    public static void println(String output) {
        System.out.println(output);
    }

    public static void printCarPaths(CarRacingGame carRacingGame) {
        println(carRacingGame.getCars());
    }

    public static void println(Car[] cars) {
        for (Car car : cars) {
            println(car);
        }
    }

    private static void println(Car car) {
        println(getCarPath(car));
    }

    private static String getCarPath(Car car) {
        StringBuilder carPath = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            carPath.append('-');
        }
        return carPath.toString();
    }
}
