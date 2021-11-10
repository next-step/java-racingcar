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
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}