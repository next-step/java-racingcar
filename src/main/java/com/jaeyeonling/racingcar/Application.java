package com.jaeyeonling.racingcar;

import com.jaeyeonling.racingcar.domain.RacingGame;
import com.jaeyeonling.racingcar.domain.RacingGameOption;
import com.jaeyeonling.racingcar.domain.RandomMoveStrategy;
import com.jaeyeonling.racingcar.view.InputView;
import com.jaeyeonling.racingcar.view.ResultView;

public class Application {

    public static void main(final String... args) {
        final InputView consoleReader = new InputView(System.in);
        final ResultView consoleWriter = new ResultView(System.out);

        final int numberOfParticipants = consoleReader.readIntWithMessage("자동차 대수는 몇 대 인가요?");
        final int moveCount = consoleReader.readIntWithMessage("시도할 회수는 몇 회 인가요?");

        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(new RandomMoveStrategy())
                .movingCount(moveCount)
                .numberOfParticipants(numberOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);

        consoleWriter.show("실행 결과");
        consoleWriter.show(racingGame.getStatus());
        while (!racingGame.isComplete()) {
            racingGame.move();
            consoleWriter.show(racingGame.getStatus());
        }
    }
}