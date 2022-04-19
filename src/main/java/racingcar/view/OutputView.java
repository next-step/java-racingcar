package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String DASH = "-";
    private static final int INITIALIZATION = 0;
    private static final String EMPTYLETTER = "";
    private static final StringBuilder result = new StringBuilder();

    public void printResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int movement = cars.get(i).getMovement();
            System.out.println(cars.get(i).getName() + " : " + plusMovement(movement));
            result.setLength(INITIALIZATION);
        }
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
        for (String winner : winners) {
            System.out.print(winner + " ");
        }
        System.out.print("가 최종 우승했습니다.");
    }
  
}
