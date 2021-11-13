package racingcar.view;

import racingcar.Car;

import java.util.List;

public class ResultView {
    private static final String MOVEMENT = "-";

    public ResultView() {
        System.out.println("실행 결과");
    }

    public void printAllCarsMovement(List<Car> result) {
        for (int i = 0; i < result.size(); i++) {
            printACarMovement(result.get(i).getMovement());
            System.out.println();
        }
        System.out.println();
    }

    private void printACarMovement(int movement) {
        for (int i = 0; i < movement; i++) System.out.print(MOVEMENT);
    }
}
