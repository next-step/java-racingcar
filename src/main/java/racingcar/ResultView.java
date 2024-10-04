package racingcar;

public class ResultView {
    public static void printMessage() {
        System.out.println("실행 결과");
    }

    public static void printResult() {
        for (Car car : RacingGame.cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getDistance(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
}
