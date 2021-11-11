package step4;

public class GameOutput {

    public static void printCarPaths(CarRacingGame carRacingGame) {
        printCars(carRacingGame.getCars());
    }

    private static void printCars(Car[] cars) {
        for (Car car : cars) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

}