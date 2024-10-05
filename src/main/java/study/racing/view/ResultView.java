package study.racing.view;

import study.racing.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final StringBuilder sb = new StringBuilder();
    private static final String END_MESSAGE = "가 최종 우승했습니다.";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVEMENT = "-";

    public void printResult() {
        sb.append('\n').append(RESULT_MESSAGE).append('\n');
    }

    public void printCarPosition(Car car) {
        sb.append(car.getName()).append(" : ");
        sb.append(CAR_MOVEMENT.repeat(car.getCurrentPosition().getValue())).append('\n');
    }

    public void separateGameRound() {
        sb.append('\n');
    }

    public void gameEnd(List<Car> winners) {
        String result = winners.stream().map(c -> c.getName().getValue()).collect(Collectors.joining(", "));
        sb.append(result).append(END_MESSAGE);
        System.out.println(sb.toString());
    }

}
