package com.jaeyeonling.racingcar;

import com.jaeyeonling.racingcar.domain.RacingGame;
import com.jaeyeonling.racingcar.domain.RacingGameOption;
import com.jaeyeonling.racingcar.domain.RacingStrategy;
import com.jaeyeonling.racingcar.view.ConsoleInputView;
import com.jaeyeonling.racingcar.view.ConsoleResultView;
import com.jaeyeonling.racingcar.view.VisualRecorder;

public class Application {

    public static void main(final String... args) {
        final String nameOfParticipants = ConsoleInputView.readNameOfParticipants();
        final int moveCount = ConsoleInputView.readMoveCount();

        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(new RacingStrategy())
                .movingCount(moveCount)
                .nameOfParticipants(nameOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);
        final VisualRecorder viewRecorder = new VisualRecorder();

        viewRecorder.recodeResultMessage();
        viewRecorder.recode(racingGame);

        while (!racingGame.isComplete()) {
            racingGame.move();
            viewRecorder.recode(racingGame);
        }

        viewRecorder.recodeVictors(racingGame.getVictors());

        ConsoleResultView.show(viewRecorder);
    }
}