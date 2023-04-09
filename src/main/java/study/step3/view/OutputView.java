package study.step3.view;

public class OutputView {

    private static final String TEXT_RESULT = "실행 결과";
    private static final String OUTPUT_TEXT = "-";

    public void outputTextOfResult() {
        System.out.println("\n" + TEXT_RESULT);
    }

    public void outputPositionOfCar(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(OUTPUT_TEXT);
        }
        System.out.println();
    }

    public void outputNextLine() {
        System.out.println();
    }
}
