package racing.util;

import racing.model.Car;
import racing.model.Racers;

import java.util.List;

public class RacingGamePrinter {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String RUN_RESULT = "실행 결과";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";
    private static final String DELIMITER = " : ";
    private static final String DISPLAY_MARK = "-";

    public void print(List<Racers> racers) {
        System.out.print(buildString(racers));
    }

    private String buildString(List<Racers> racers) {
        StringBuilder sb = new StringBuilder(RUN_RESULT).append(NEW_LINE);
        for (int i = 0; i < racers.size(); i++) {
            append(racers, sb, i, racers.size());
        }
        return sb.toString();
    }

    private void append(List<Racers> racers, StringBuilder sb, int i, int size) {
        Racers racer = racers.get(i);
        for (int j = 0; j < racer.size(); j++) {
            append(sb, racer, j);
            sb.append(NEW_LINE);
        }
        sb.append(NEW_LINE);
        append(sb, i, size, racer);
    }

    private void append(StringBuilder sb, Racers racer, int j) {
        Car car = (Car) racer.get(j);
        sb.append(car.name());
        sb.append(DELIMITER);
        append(sb, car.position());
    }

    private void append(StringBuilder sb, int position) {
        sb.append(DISPLAY_MARK.repeat(position));
    }

    private void append(StringBuilder sb, int i, int size, Racers racer) {
        if (i == size - 1) {
            sb.append(racer.winner());
            sb.append(END_MESSAGE);
        }
    }
}
