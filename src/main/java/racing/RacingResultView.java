package racing;

import java.util.List;

public class RacingResultView {

    private static final String MOVE_CAR_EXPRESSION = "- ";

    public void print(List<Car> racingCars) {
        for (Car racingCar : racingCars) {
            int carPosition = racingCar.position;
            execute(carPosition);
        }
        System.out.println();
    }

    private void execute(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(MOVE_CAR_EXPRESSION);
        }
        System.out.println();
    }
}
