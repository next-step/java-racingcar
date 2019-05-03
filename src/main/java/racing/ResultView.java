package racing;

public class ResultView {
    public static void printCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getObject()) {
            System.out.println(racingCar.toString());
        }
    }
}
