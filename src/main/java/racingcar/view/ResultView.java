package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    public void printWinners(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printResult(List<List<Car>> results) {
        for (List<Car> roundResult : results) {
            this.printAsterisk();
            printRound(roundResult);
        }
    }

    private void printRound(List<Car> roundResult) {
        for (Car car : roundResult) {
            this.printPosition(car);
        }
    }

    private void printPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int j = 0; j < car.getPosition(); j++) {
            System.out.print('-');
        }
        System.out.println();
    }

    private void printAsterisk() {
        System.out.println("*******************************************");
    }
}
