package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static final String CAR_MOVEMENT_SINGLE_STEP = "-";
    public static void printMovementOneRace(List<Car> cars) {
        for (Car car : cars) {
            String movementStep = IntStream.range(0, car.getMovementCount())
                    .mapToObj(i -> CAR_MOVEMENT_SINGLE_STEP)
                    .collect(Collectors.joining());
            System.out.println(movementStep);
        }

        System.out.println();
    }

    public static void printRacingWinner(List<Car> winnerCars) {
        // 개선.
        StringBuilder sb = new StringBuilder();
        for (Car winnerCar : winnerCars) {
            sb.append(winnerCar.getCarName()).append(", ");
        }
        System.out.println(sb + "가 최종 우승했습니다.");
    }
}
