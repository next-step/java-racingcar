package racing.view;

import racing.model.Car;
import racing.model.Cars;

import java.util.List;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder result;

    public String getResultView(Cars cars) {
        record(cars.getWinnerNames() + "(이)가 최종 우승했습니다.");

        return getResult();
    }

    public ResultView() {
        result = new StringBuilder();
    }

    public void appendResultHeader() {
        result.append("실행 결과");
        appendNewLine();
    }

    private void appendNewLine() {
        result.append(NEW_LINE);
    }

    private void record(String history) {
        result.append(history);
        appendNewLine();
    }

    public void appendCurrentSituation(List<Car> cars) {
        for (Car car : cars) {
            result.append(car.getName() + " : " + car.getPosition(HYPHEN));
            appendNewLine();
        }
        appendNewLine();
    }


    /**
     * Test Code 작성을 위한 pulbic getter() 메서드
     */
    public String getResult() {
        return result.toString();
    }
}
