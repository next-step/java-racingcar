package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarState;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String PATTERN = "-";

    public void print(List<List<CarState>> results) {
        System.out.println();
        System.out.println("실행 결과");

        printRunResult(results);
        printFinalRunResult(results.get(results.size() - 1));
        System.out.println();
    }

    private void printFinalRunResult(List<CarState> carStates) {
        printCarState(carStates);
    }

    private void printRunResult(List<List<CarState>> results) {
        for (List<CarState> result : results) {
            printCarState(result);
        }
    }

    private void printCarState(List<CarState> result) {
        for (CarState car : result) {
            printPattern(car);
        }
        System.out.println();
    }

    private void printPattern(CarState car) {
        System.out.println(String.join(" : ", car.getName(), PATTERN.repeat(car.getPosition())));
    }

    public void printWinners(List<Car> winners) {
        System.out.println(String.join(", ",  getWinnerName(winners)) + "가 최종 우승했습니다.");
    }

    private List<String> getWinnerName(List<Car> winners) {
        List<String> carNames = new ArrayList<>();
        for(Car car : winners){
            car.addName(carNames);
        }
        return carNames;
    }
}
