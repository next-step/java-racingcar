package racing.view;

import org.apache.commons.lang3.StringUtils;
import racing.Results;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Result;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String POSITION_BAR = "-";
    private static final String COLON = ":";
    private static final String SPACE = " ";
    private static final String COMMA = ",";

    private OutputView() {
    }

    public static void printResults(Results results) {
        printTitle();

        for (Result result : results.getResults()) {
            printResult(result);
        }

        printWinners(results.getFinalWinners());
    }

    private static void printTitle() {
        System.out.println("실행 결과");
    }

    private static void printResult(Result result) {
        Cars cars = result.getCars();
        List<Car> carList = cars.getCars();
        carList.forEach(car ->
                System.out.println(car.getName() + COLON + SPACE + StringUtils.repeat(POSITION_BAR, car.getPosition()))
        );

        System.out.println();
    }

    private static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println(StringUtils.join(winnerNames, COMMA + SPACE) + "가 최종 우승했습니다.");
    }
}
