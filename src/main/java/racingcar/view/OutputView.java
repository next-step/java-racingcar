package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String DASH = "-";
    private static final int INITIALIZATION = 0;
    private static final String EMPTYLETTER = "";
    private static final StringBuilder result = new StringBuilder();

    public void printResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + plusMovement(car.getMovement()));
            result.setLength(INITIALIZATION);
        });
        printVacuum();
    }

    public StringBuilder plusMovement(int movement) {
        for (int i = 0; i < movement; i++) {
            result.append(DASH);
        }
        return result;
    }

    public void printVacuum() {
        System.out.println(EMPTYLETTER);
    }

    public void printWinner(List<String> winners) {
        winners.forEach(winner -> System.out.print(winner + " "));
        System.out.print("가 최종 우승했습니다.");
    }
  
}
