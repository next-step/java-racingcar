package racing;

public class ResultView {
    public static void printMoveCar(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getObjects()) {
            System.out.println(racingCar.toString());
        }
        System.out.println();
    }

    public static void printWinners(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void executeResult() {
        System.out.println("실행결과");
    }
}
