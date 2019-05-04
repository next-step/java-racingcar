package racing;

public class ResultView {
    public static void printCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getObjects()) {
            System.out.println(racingCar.toString());
        }
    }
}
