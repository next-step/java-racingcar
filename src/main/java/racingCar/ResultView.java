package racingCar;

public class ResultView {
    public static void printEachRound(Car[] cars) {
        for (Car car : cars) {
            System.out.println("-".repeat(car.getDistance()));
        }
        System.out.println();
    }
}
