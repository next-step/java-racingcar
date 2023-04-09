package study.step3.view;

public class OutputView {

    private static final String TEXT_RESULT = "실행 결과";
    private static final String OUTPUT_TEXT = "-";

    public void outputTextOfResult() {
        System.out.println("\n" + TEXT_RESULT);
    }

    public void outputPositionOfCar(int[] positionOfCars) {
        for (int i = 0; i < positionOfCars.length; i++) {
            for (int j = 0; j < positionOfCars[i]; j++) {
                System.out.print(OUTPUT_TEXT);
            }
            System.out.println();
        }
    }
}
