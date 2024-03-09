package view;

import model.Car;

public class ResultView {

    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder sb;

    public ResultView() {
        this.sb = new StringBuilder();

        this.sb.append("실행결과");
        appendNewLine();
    }

    public void record(Car car) {
        sb.append(HYPHEN.repeat(car.getPosition()));
        appendNewLine();
    }

    public void appendNewLine() {
        sb.append(NEW_LINE);
    }

    public void print() {
        System.out.println(sb.toString());
    }

}
