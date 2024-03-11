package racing.view;

import racing.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder result;

    public String getResultView(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            getCarPosition(cars, i);
            appendNewLine();
        }

        record(getWinnerNames(cars) + "(이)가 최종 우승했습니다.");

        return getResult();
    }

    private void getCarPosition(List<Car> cars, int index) {
        for (int i = 0; i < cars.size(); i++) {
            String carName = cars.get(i).getName();
            String carPosition = cars.get(i).getPosition(index);
            record(carName + " : " + carPosition);
        }
    }

    public ResultView() {
        result = new StringBuilder();
        appendResultHeader();
    }

    private void appendResultHeader() {
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

    private String getWinnerNames(List<Car> cars) {
        List<Car> topScores = getTheHighestScore(cars);

        String winnerNames = topScores.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return winnerNames;
    }

    private List<Car> getTheHighestScore(List<Car> cars) {
        int maxScore = cars.stream().mapToInt(Car::getScore).max().orElse(0);

        List<Car> topScores = cars.stream()
                .filter(car -> car.getScore() == maxScore)
                .collect(Collectors.toList());

        return topScores;
    }

    /**
     * Test Code 작성을 위한 pulbic getter() 메서드
     */
    public String getResult() {
        return result.toString();
    }
}
