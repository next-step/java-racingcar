package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    private static final String DASH = "-";
    private static final int INITIALIZATION = 0;
    private static final String EMPTYLETTER = "";
    private static final StringBuilder result = new StringBuilder();

    public void printResult(Car car) {
        result.setLength(INITIALIZATION);
        for (int i = INITIALIZATION; i < car.getMovement(); i++) {
            result.append(DASH);
        }
        System.out.println(result);
    }

    public void printVacuum() {
        System.out.println(EMPTYLETTER);
    }
}
