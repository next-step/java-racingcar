import java.util.List;

public class ResultView {

    public static void printRaceRound(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("\n");
    }

    public static void printExecuteResult() {
        System.out.println("실행 결과");
    }
}
