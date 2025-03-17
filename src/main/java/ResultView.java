import java.util.List;

public class ResultView {

    public static void printRaceRound(List<Car> carList) {
        for (Car car : carList) {
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println("\n");
    }
}
