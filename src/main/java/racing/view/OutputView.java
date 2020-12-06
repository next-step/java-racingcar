package racing.view;

import org.apache.commons.lang3.StringUtils;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static final String POSITION_BAR = "-";

    private OutputView() {
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        List<Car> carList = cars.getCars();
        carList.forEach(car -> System.out.println(car.getName() + ": " + StringUtils.repeat(POSITION_BAR, car.getPosition())));

        System.out.println();
    }

    public static void printWinners(Cars cars) {
        List<Car> winners = cars.getWinners();

        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println(StringUtils.join(winnerNames, ", ") + "가 최종 우승했습니다.");
    }
}
