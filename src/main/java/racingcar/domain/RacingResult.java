package racingcar.domain;

import java.util.List;
import racingcar.domain.car.Car;

public class RacingResult {

    private static String RESULT_LINE = "%s : ";
    private static String DASH = "-";
    private static StringBuilder stringBuilder;
    private List<Car> cars;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingResult getInstance(List<Car> cars) {
        return new RacingResult(cars);
    }

    public void getResultView() {
        for (int i = 0; i < cars.size(); i++) {
            stringBuilder = new StringBuilder();

            int status = cars.get(i).getStatus();
            System.out.printf(RESULT_LINE, cars.get(i).getName());
            while (status-- > 0) {
                stringBuilder.append(DASH);
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }
}
