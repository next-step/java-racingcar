package step3.view;

import step3.domain.Car;
import step3.domain.Cars;
import step3.domain.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String WINNER_ANNOUNCE_POSTFIX = "가 최종 우승했습니다.";
    private static final String POSITION_OF_CAR = "-";
    private static final String WINNER_NAME_SEPARATOR = ", ";
    private static final String CAR_NAME_SEPARATOR = " : ";

    public void showResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void showResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCars(car);
        }
        printEmptyLine();
    }

    public void printWinners(Winners winners) {
        List<String> winnerNames = winners.getWinners().stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
        String winnerAnnounce = separateWinnerNames(winnerNames);
        System.out.println(winnerAnnounce + WINNER_ANNOUNCE_POSTFIX);
    }

    private String separateWinnerNames(List<String> winnerNames) {
        return winnerNames.stream()
                .reduce((s, s2) -> s + WINNER_NAME_SEPARATOR + s2)
                .get();
    }

    private void printCars(Car car) {
        printCarName(car.getCarName());
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(POSITION_OF_CAR);
        }
        printEmptyLine();
    }

    private void printCarName(String carName) {
        System.out.print(carName + CAR_NAME_SEPARATOR);
    }

    private void printEmptyLine() {
        System.out.println();
    }

}
