package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class ConsoleResultView implements ResultView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car: cars) {
            printLane(car);
        }

        System.out.println();
    }

    private void printLane(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerNames) {
        String winners = String.join(", ", winnerNames);
        System.out.println(winners + "이(가) 최종 우승했습니다.");
    }
}
