package com.jaeyeonling.racingcar;

import com.jaeyeonling.racingcar.domain.RacingGame;
import com.jaeyeonling.racingcar.domain.RacingGameOption;
import com.jaeyeonling.racingcar.domain.RacingStrategy;
import com.jaeyeonling.racingcar.view.ConsoleInputView;
import com.jaeyeonling.racingcar.view.ConsoleResultView;
import com.jaeyeonling.racingcar.view.VisualRecorder;

public class Application {

    public static void main(final String... args) {
        final int numberOfParticipants = ConsoleInputView.readIntWithMessage("자동차 대수는 몇 대 인가요?");
        final int moveCount = ConsoleInputView.readIntWithMessage("시도할 회수는 몇 회 인가요?");

        final RacingGameOption racingGameOption = RacingGameOption.builder()
                .moveStrategy(new RacingStrategy())
                .movingCount(moveCount)
                .numberOfParticipants(numberOfParticipants)
                .build();

        final RacingGame racingGame = new RacingGame(racingGameOption);
        final VisualRecorder viewRecorder = new VisualRecorder();

        viewRecorder.newLine();
        viewRecorder.recode("실행 결과");
        viewRecorder.recode(racingGame);

        while (!racingGame.isComplete()) {
            racingGame.move();
            viewRecorder.recode(racingGame);
        }

        ConsoleResultView.show(viewRecorder);
    }
}