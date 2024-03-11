package racing.view;

import racing.model.Car;

import java.util.List;

public class ResultView {
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder result;

    public String getResultView(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            getCarPosition(cars, i);
            appendNewLine();
        }

        return getResult();
    }

    private void getCarPosition(List<Car> cars, int index) {
        for (int i = 0; i < cars.size(); i++) {
            record(cars.get(i).getPosition(index));
        }
    }

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

    public void record(String position) {
        result.append(position);
        appendNewLine();
    }

    /**
     * Test Code 작성을 위한 getter() 메서드
     */
    public String getResult() {
        return result.toString();
    }
}
