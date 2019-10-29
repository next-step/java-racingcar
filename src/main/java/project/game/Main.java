package project.game;

import java.util.List;

import static project.game.StringConstant.*;

public class Main {


    public static void main(String[] args) {
        View view = new ConsoleView();

        view.drawText(RACING_GAME_START_TEXT);

        view.drawText(CAR_COUNT_INPUT_FORM_TEXT);
        int carCount = view.readInputToInt();
        view.drawText(ROUND_COUNT_INPUT_FORM_TEXT);
        List<String> carNames = StringUtils.splitStringToList(view.readInput(), ",");

        RacingGameNotifier notifier = carPositions -> {
            view.drawNewLine();

            for (Integer carPosition : carPositions) {
                view.drawCharSequence(carPosition, RacingGame.CAR_POSITION_TEXT);
            }
        };

        RacingGame racingGame = new RacingGame(notifier);
        racingGame.start(GameType.RANDOM, carNames, carCount);

        view.drawText(RACING_GAME_END_TEXT);
    }

}
