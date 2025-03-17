import java.util.List;

public class ResultView {
    public void present(String result) {
        System.out.println(result);
    }

    public void presentCars(List<Integer> carPositions) {
        for (int carPosition : carPositions) {
            System.out.println("-".repeat(carPosition + 1));
        }
        System.out.println();
    }
}
