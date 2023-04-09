import java.util.List;
import java.util.Map;

public class PrintView {

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printCar(Cars cars, int round) {
        Map<Car, List<Integer>> distancesOfCar = cars.distancesOfCar();

        distancesOfCar.forEach((key, value) -> {
            System.out.print(key.name() + " : ");
            printDistance(value.get(round));
        });

        System.out.println();
    }

    private static void printDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
