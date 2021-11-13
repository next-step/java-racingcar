package racinggame.view;

import racinggame.domain.value.Names;
import racinggame.domain.value.RacingResult;

import java.util.List;

public class ResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행결과";
    private static final String DIVISION = "";
    private static final String OUTPUT_SYMBOL = "-";
    private static final String NAME_SYMBOL_DIVISION = " : ";
    private static final String WINNER_JOIN_DIVISION =", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final int SOLO_WINNER = 1;

    private final RacingResult racingResult;

    public ResultView(RacingResult racingResult) {
        this.racingResult = racingResult;
    }

    public void showResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);

        racingResult.results()
                .forEach(moveResult -> {
                        moveResult.results()
                                .forEach(car -> {
                                    System.out.print(car.name());
                                    System.out.print(NAME_SYMBOL_DIVISION);
                                    System.out.println(printResult(car.position()));
                    });
            System.out.println(DIVISION);
        });

        printWinners();
    }

    private String printResult(int result) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result; i++) {
            builder.append(OUTPUT_SYMBOL);
        }
        return builder.toString();
    }

    private void printWinners() {
        System.out.printf("%s%s", joinedWinnerNames(), WINNER_MESSAGE);
    }

    private String joinedWinnerNames() {
        Names winners = racingResult.findWinners();
        List<String> names = winners.names();

        if (names.size() == SOLO_WINNER) {
            return names.get(0);
        }

        return String.join(WINNER_JOIN_DIVISION, names);
    }
}
