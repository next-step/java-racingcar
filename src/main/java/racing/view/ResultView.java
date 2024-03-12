package racing.view;

import racing.model.Car;
import racing.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DELIMITER = ", ";
    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder result;

    public ResultView() {
        result = new StringBuilder();
    }

    public void appendResultHeader() {
        result.append("실행 결과");
        appendNewLine();
    }

    private void appendNewLine() {
        result.append(NEW_LINE);
    }

    private void record(String history) {
        result.append(history);
        appendNewLine();
    }

    public void appendCurrentSituation(List<Car> cars) {
        for (Car car : cars) {
            result.append(car.getName() + " : " + car.getPosition(HYPHEN));
            appendNewLine();
        }
        appendNewLine();
    }

    public void getResultView(Cars cars) {
        record(getWinnerNames(cars) + "(이)가 최종 우승했습니다.");
        System.out.println(getResult());
    }

    private String getWinnerNames(Cars cars) {
        List<Car> topScores = cars.getTheHighestScoreDrivers();
        return splitWinnerNames(topScores);
    }

    private String splitWinnerNames(List<Car> cars) {
        String winnerNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));

        return winnerNames;
    }

    private String getResult() {
        return result.toString();
    }
}
