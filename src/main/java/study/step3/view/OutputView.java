package study.step3.view;

import java.util.List;

public class OutputView {

    private static final String TEXT_RESULT = "실행 결과";
    private static final String OUTPUT_TEXT = "-";

    public void outputTextOfResult() {
        System.out.println("\n" + TEXT_RESULT);
    }

    public void outputPositionOfCar(List<Integer> positionOfCars) {
        for (int position : positionOfCars) {
            for (int i = 0; i < position; i++) {
                System.out.print(OUTPUT_TEXT);
            }
            System.out.println();
        }
        System.out.println();
    }
}
