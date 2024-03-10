package racing.view;

import racing.model.Car;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder result;

    public ResultView() {
        result = new StringBuilder();
        appendResultHeader();
    }

    public void appendResultHeader() {
        result.append("실행 결과");
        appendNewLine();
    }

    public void appendNewLine() {
        result.append(NEW_LINE);
    }

    public void record(Car car) {
        String carPosition = HYPHEN.repeat(car.getScore());
        result.append(carPosition);
        appendNewLine();
    }

    /**
     * Test Code 작성을 위한 getter() 메서드
     */
    public String getResult() {
        return result.toString();
    }
}
