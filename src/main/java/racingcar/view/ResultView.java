package racingcar.view;

import racingcar.dto.Round;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RACE_TRACK = "-";

    private List<Round> rounds;

    public ResultView(List<Round> rounds) {
        this.rounds = rounds;
    }

    public static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printGameResult() {
        for (Round round : rounds) {
            printRound(round);
        }
    }

    private void printRound(Round round) {
        List<Integer> carsStatus = Round.roundResult(round);
        for (int status : carsStatus) {
            printTrack(status);
        }
        System.out.println();
    }

    private void printTrack(int distance) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(RACE_TRACK);
        }
        System.out.println(sb.toString());
    }
}
