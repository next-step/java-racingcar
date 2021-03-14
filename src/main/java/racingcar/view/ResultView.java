package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.Round;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RACE_TRACK = "-";

    private List<Round> rounds;

    public ResultView(List<Round> rounds) {
        this.rounds = rounds;
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
        rounds.stream()
                .map(this::roundResult)
                .forEach(System.out::println);
    }

    private String roundResult(Round round) {
        return round.getAllCars()
                .getCarsAtRound()
                .stream()
                .map(this::carResult)
                .reduce("", String::concat);
    }

    private String carResult(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(RACE_TRACK);
        }
        sb.append('\n');
        return sb.toString();
    }
}
