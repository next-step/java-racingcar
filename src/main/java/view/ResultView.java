package view;

import model.Car;
import model.Cars;
import model.RacingRecord;

import java.util.List;

public class ResultView {

    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();

    private final List<Cars> records;
    private final List<String> winners;
    private final StringBuilder sb;

    public ResultView(RacingRecord racingRecord) {
        this.records = racingRecord.getRecords();
        this.winners = racingRecord.getWinners();
        this.sb = new StringBuilder();
    }

    public void draw() {
        appendPrefix();
        render();
        appendWinners();
    }

    private void appendPrefix() {
        sb.append("실행결과");
        appendNewLine();
    }

    private void render() {
        for (Cars cars : records) {
            template(cars);
            appendNewLine();
        }
    }

    private void template(Cars cars) {
        for (Car car : cars.getCars()) {
            sb.append(rendering(car));
            appendNewLine();
        }
    }

    private String rendering(Car car) {
        return String.format("%s : %s", car.getName(), HYPHEN.repeat(car.getPosition()));
    }

    private void appendWinners() {
        sb.append(String.join(", ", this.winners)).append("가 최종 우승 했습니다");
    }

    private void appendNewLine() {
        sb.append(NEW_LINE);
    }

    public void print() {
        System.out.println(sb.toString());
    }

}
