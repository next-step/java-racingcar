package calculator.view;

public class OutputView {
    private final int result;

    public OutputView(int result) {
        this.result = result;
    }


    public void printResult() {
        System.out.println("출력값 = " + result);
    }
}
