package racing;

public class ResultView {
    public static void printCars(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getObjects()) {
            System.out.println(racingCar.toString());
        }
    }

    public static void printWinners(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
