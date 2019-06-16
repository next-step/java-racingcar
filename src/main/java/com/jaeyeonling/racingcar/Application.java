package com.jaeyeonling.racingcar;

import com.jaeyeonling.racingcar.domain.RacingGame;
import com.jaeyeonling.racingcar.domain.RacingGameOption;
import com.jaeyeonling.racingcar.domain.RandomMoveStrategy;
import com.jaeyeonling.racingcar.view.ConsoleInputView;
import com.jaeyeonling.racingcar.view.ConsoleResultView;

public class Application {

    public static void main(final String... args) {
        final int numberOfParticipants = ConsoleInputView.readIntWithMessage("자동차 대수는 몇 대 인가요?");
        final int moveCount = ConsoleInputView.readIntWithMessage("시도할 회수는 몇 회 인가요?");

        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(new RandomMoveStrategy())
                .movingCount(moveCount)
                .numberOfParticipants(numberOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);

        ConsoleResultView.newLine();
        ConsoleResultView.show("실행 결과");
        ConsoleResultView.show(racingGame);
        while (!racingGame.isComplete()) {
            racingGame.move();
            ConsoleResultView.show(racingGame);
        }
    }
}