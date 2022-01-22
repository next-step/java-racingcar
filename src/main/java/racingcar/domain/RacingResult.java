package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class RacingResult {

    private static String RESULT_LINE = "%s : ";
    private static String DASH = "-";
    private List<Car> cars;

    private RacingResult(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingResult getInstance(List<Car> cars) {
        return new RacingResult(cars);
    }

    public void getResultView() {
        for (int i = 0; i < cars.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();

            int status = cars.get(i).getPosition();
            System.out.printf(RESULT_LINE, cars.get(i).getName());
            while (status-- > 0) {
                stringBuilder.append(DASH);
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }

    public void getWinner() {
        StringBuilder stringBuilder = new StringBuilder("최종 우승자: ");

        Collections.sort(cars);
        Car firstWinner = cars.get(0);

        String winners = cars.stream()
            .filter(car -> car.compareStatus(firstWinner))
            .map(car -> car.getName())
            .collect(Collectors.joining(", "));

        System.out.println(stringBuilder.append(winners).toString());
    }

    public void moveCarIfPositionChanged(int index, boolean bool) {
        if (bool) {
            this.cars.get(index).go();
        }
    }
}
