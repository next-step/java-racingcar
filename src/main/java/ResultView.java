import java.util.List;

public class ResultView {

    public void presentStartMessage() {
        System.out.println("실행 결과");
    }

    public void presentCars(List<CarStatus> cars) {
        for (CarStatus car : cars) {
            String positionIndicator = "-".repeat(car.getPosition() + 1);
            String output = String.format("%s : %s", car.getName(), positionIndicator);
            System.out.println(output);
        }
        System.out.println();
    }
}
