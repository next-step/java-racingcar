package step_3;

import java.util.List;

public class ResultView {

    private static final String PRINT_DISTANCE_MARK = "-";
    private final StringBuilder carMoveDistanceResult = new StringBuilder();

    public void saveRaceResult(List<Car> cars) {
        for (Car car : cars) {
            saveCarDistance(car.distance());
        }
        carMoveDistanceResult.append(System.lineSeparator());
    }

    private void saveCarDistance(int distance) {
        for (int i = 0; i < distance; i++) {
            carMoveDistanceResult.append(PRINT_DISTANCE_MARK);
        }
        carMoveDistanceResult.append(System.lineSeparator());
    }

    public void viewResult() {
        System.out.println(carMoveDistanceResult);
    }
}
