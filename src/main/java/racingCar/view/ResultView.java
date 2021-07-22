package racingCar.view;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";

    public void printExecutionResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printCarDistance(int distance) {
        for(int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
