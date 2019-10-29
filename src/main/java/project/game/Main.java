package project.game;

import static project.game.StringConstant.*;

public class Main {


    public static void main(String[] args) {
        View view = new ConsoleView();

        view.drawText(RACING_GAME_START_TEXT);

        int carCount;
        int roundCount;

        try {
            view.drawText(CAR_COUNT_INPUT_FORM_TEXT);
            carCount = view.readInputToInt();

            view.drawText(ROUND_COUNT_INPUT_FORM_TEXT);
            roundCount = view.readInputToInt();
        } catch (NumberFormatException exception) {
            view.drawText(String.format(INPUT_FORMAT_ERROR, exception.getMessage()));
            return;
        }

        RacingGameNotifier notifier = carPositions -> {
            view.drawNewLine();

            for (Integer carPosition : carPositions) {
                view.drawCharSequence(carPosition, RacingGame.CAR_POSITION_TEXT);
            }
        };
        RacingGame racingGame = new RacingGame(notifier);
        racingGame.start(GameType.RANDOM, carCount, roundCount);

        view.drawText(RACING_GAME_END_TEXT);
    }

}
