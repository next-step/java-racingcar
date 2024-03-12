package view;

import model.Car;
import model.Cars;
import model.RacingRecord;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {

    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();

    public ResultView() {
    }

    public void print(RacingRecord record) {
        StringBuilder sb = new StringBuilder();

        draw(sb, record);

        System.out.println(sb);
    }

    private void draw(StringBuilder sb, RacingRecord record) {
        sb.append("실행결과").append(NEW_LINE);
        render(sb, record.getRecords());
        appendWinners(sb, record.winners());
    }

    private void render(StringBuilder sb, List<Cars> records) {
        for (Cars cars : records) {
            template(sb, cars);
            sb.append(NEW_LINE);
        }
    }

    private void template(StringBuilder sb, Cars cars) {
        for (Car car : cars.getCars()) {
            sb.append(rendering(car)).append(NEW_LINE);
        }
    }

    private String rendering(Car car) {
        return String.format("%s : %s", car.getName(), HYPHEN.repeat(car.getPosition()));
    }

    private void appendWinners(StringBuilder sb, List<Car> winners) {
        sb.append(joinWinnerNames(winners)).append("가 최종 우승 했습니다");
    }

    private String joinWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(joining(", "));
    }

}
