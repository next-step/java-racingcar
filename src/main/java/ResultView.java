import java.util.List;

public class ResultView {

    public void presentStartMessage() {
        System.out.println("실행 결과");
    }

    public void presentCars(List<Integer> carPositions) {
        for (int carPosition : carPositions) {
            System.out.println("-".repeat(carPosition + 1));
        }
        System.out.println();
    }
}
