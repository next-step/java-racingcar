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
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public static void printWinners(Car[] winners) {
        for (Car winner : winners) {
            System.out.print(winner.getName() + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}