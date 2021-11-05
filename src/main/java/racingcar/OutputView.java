package racingcar;


import java.util.List;

public class OutputView {
    private final static String RACE_PRINT_CHARACTER = "-";
    private final static String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void printCurrentPositionOfCars(List<Integer> currentPositionOfCars) {
        currentPositionOfCars.forEach(this::printCurrentPositionOfCar);
        System.out.println();
    }

    private void printCurrentPositionOfCar(int currentPosition) {
        for (int i = 0; i <= currentPosition; i++) {
            System.out.print(RACE_PRINT_CHARACTER);
        }
        System.out.println();
    }
}
