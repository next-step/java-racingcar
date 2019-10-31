package project.game;

import java.util.List;

import static project.game.StringConstant.*;

public class Main {


    public static void main(String[] args) {
        View view = new ConsoleView();

        view.drawText(RACING_GAME_START_TEXT);

        view.drawText(CAR_NAME_INPUT_FORM_TEXT);
        List<String> carNames = StringUtils.splitStringToList(view.readInput(), COMMA_DELIMITER);
        view.drawText(ROUND_COUNT_INPUT_FORM_TEXT);
        int carCount = view.readInputToInt();

        RacingGameNotifier notifier = new RacingGameNotifier() {
            @Override
            public void onResultRacingRound(List<Integer> carPositions) {
                view.drawNewLine();

                for (Integer carPosition : carPositions) {
                    view.drawCharSequence(carPosition, RacingGame.CAR_POSITION_TEXT);
                }
            }

            @Override
            public void onResultRacingWinnerNames(List<String> winnerNames) {
                view.drawText(RACING_GAME_END_TEXT);

                String winnerText = String.format(RACING_GAME_WINNERS, String.join(COMMA_DELIMITER, winnerNames));
                view.drawText(winnerText);
            }
        };

        RacingGame racingGame = new RacingGame(notifier);
        racingGame.start(GameType.RANDOM, carNames, carCount);

        view.drawText(RACING_GAME_END_TEXT);
    }

}
