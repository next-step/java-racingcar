package view;

import model.Car;
import model.Cars;
import model.RacingRecord;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();

    private final StringBuilder sb;

    public ResultView() {
        this.sb = new StringBuilder();
    }

    public void draw(RacingRecord record) {
        appendPrefix();
        render(record.getRecords());
        appendWinners(record.getWinners());
    }

    private void appendPrefix() {
        sb.append("실행결과");
        appendNewLine();
    }

    private void render(List<Cars> records) {
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

    private void appendWinners(List<Car> winners) {
        sb.append(joinWinnerNames(winners)).append("가 최종 우승 했습니다");
    }

    private String joinWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(joining(", "));
    }

    private void appendNewLine() {
        sb.append(NEW_LINE);
    }

    public void print() {
        System.out.println(sb);
    }

}
