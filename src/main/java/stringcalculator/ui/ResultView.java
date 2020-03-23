package stringcalculator.ui;

public class ResultView {

    private double resultValue;

    public ResultView(double resultValue) {
        this.resultValue = resultValue;
    }

    public void print() {
        System.out.printf("실행결과: %f", resultValue);
    }
}
