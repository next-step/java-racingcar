package racingcar.dto;

import racingcar.RandomNumGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String BLANK = " ";
    private static final String ONE_MOVE = "-";
    private static final String DELIMITER_FOR_WINNER = ",";
    private Cars cars;
    private RandomNumGenerator randomNumGenerator;

    public OutputView(Cars cars, RandomNumGenerator randomNumGenerator) {
        this.cars = cars;
        this.randomNumGenerator = randomNumGenerator;
    }

    public void printCarsAfterTryCountMove(int tryCount) {
        System.out.println("실행결과");

        for (int i = 0; i < tryCount; i++) {
            printTryCount(i);
            printCarsAfterMoveOnce();
        }

        printBorderLine();
    }

    private void printTryCount(int currentTryCount) {
        printBorderLine();
        System.out.println("[" + (currentTryCount + 1) + "회차]");
        System.out.println();
    }

    private void printCarsAfterMoveOnce() {
        List<Car> allCars = cars.getCars();
        cars.moveOnce(randomNumGenerator);
        List<String> carNames = makeCarNamesPrettier(allCars);
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " |");
            printPosition(allCars.get(i));
        }
    }

    private void printPosition(Car car) {
        StringBuilder strPosition = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            strPosition.append(ONE_MOVE);
        }

        System.out.println(strPosition);
    }

    private List<String> makeCarNamesPrettier(List<Car> cars) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.getName());
        }
        return cars.stream()
                .map(it -> it.getName())
                .map(it -> it + makeBlankSpace(findLongestNameLength(carNames) - it.length()))
                .collect(Collectors.toList());
    }

    private StringBuilder makeBlankSpace(int blankLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < blankLength; i++) {
            stringBuilder.append(BLANK);
        }
        return stringBuilder;
    }

    private int findLongestNameLength(List<String> carNames) {
        return carNames.stream()
                .map(it -> it.length())
                .max(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(RuntimeException::new);
    }

    public void printWinners(List<Car> winners) {
        System.out.println();
        String winnerResult = makeWinnersNameInOneLine(winners);
        System.out.println(">>>>>>>> " + winnerResult + " (이)가 최종 우승했습니다. <<<<<<<<");
    }

    private String makeWinnersNameInOneLine(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER_FOR_WINNER));
    }

    private void printBorderLine() {
        System.out.println("=====================================");
    }
}