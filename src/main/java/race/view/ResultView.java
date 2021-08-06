package race.view;

import race.domain.Car;
import race.domain.Cars;
import race.domain.Name;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class ResultView {

    private static ResultView resultView;
    private static final String DELIMITER = ",";
    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String RESULT_START_FORMAT = "실행 결과";
    private static final String RESULT_END_FORMAT = "가 최종 우승했습니다.";

    public static synchronized ResultView getInstance() {
        if (resultView == null) {
            return new ResultView();
        }
        return resultView;
    }

    public void operate(Cars cars, int finalTryCount) {
        out.println(RESULT_START_FORMAT);
        printCarsByRound(cars, finalTryCount);
        printWinner(cars);
    }

    private void printWinner(Cars cars) {
        List<Name> winnerNames = cars.findWinners();
        String winners = winnerNames.stream()
                .map(Name::toString)
                .collect(Collectors.joining(DELIMITER));
        out.println(winners + RESULT_END_FORMAT);
    }

    private void printCarsByRound(Cars cars, int finalTryCount) {
        for (int tryCount = 0; tryCount <= finalTryCount; tryCount++) {
            printCars(cars, tryCount);
            out.println();
        }
    }

    private void printCars(Cars cars, int tryCount) {
        List<Car> carsInfo = cars.findCarsInfo();

        carsInfo.forEach(car -> {
                    out.print(car.getName().toString() + COLON + DASH);
                    out.println(String.join("", Collections.nCopies(car.getDistance(tryCount), DASH)));
                });
    }

    private ResultView() {

    }

}
