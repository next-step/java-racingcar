package racinggame.view;

import racinggame.vo.MoveResult;
import racinggame.vo.Winners;

import java.util.List;

public class ResultView {

    private static final String EXECUTE_RESULT_MESSAGE = "실행결과";
    private static final String DIVISION = "";
    private static final String OUTPUT_SYMBOL = "-";
    private static final String NAME_SYMBOL_DIVISION = " : ";
    private static final String WINNER_JOIN_DIVISION =", ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final int SOLO_WINNER = 1;

    private final List<MoveResult> moveResults;
    private final Winners winners;

    public ResultView(List<MoveResult> moveResults, Winners winners) {
        this.moveResults = moveResults;
        this.winners = winners;
    }

    public void showResult() {
        System.out.println(EXECUTE_RESULT_MESSAGE);

        moveResults.forEach(moveResult -> {
            moveResult.getResults()
                    .forEach(result -> {
                        System.out.print(result.assignName());
                        System.out.print(NAME_SYMBOL_DIVISION);
                        System.out.println(printResult(result.currentPosition()));
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
        List<String> names = winners.names();
        if (names.size() == SOLO_WINNER) {
            return names.get(0);
        }

        return String.join(WINNER_JOIN_DIVISION, names);
    }
}
