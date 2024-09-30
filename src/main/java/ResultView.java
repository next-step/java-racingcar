import java.util.List;

public class ResultView {
    public static void printIntroductionResult() {
        System.out.println("실행 결과");
    }

    public static void printResult(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(Math.max(0, car.getStatus())));
        }
        System.out.println();
    }
}
