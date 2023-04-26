package step5.domain;

import step5.dto.UserInput;
import step5.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    public List<RacingGameResult> startGame() {
        UserInput userInput = InputView.getRacingOption();
        RacingOption racingOption = RacingOption.from(userInput);
        RacingTrack racingTrack = RacingTrack.of(racingOption);

        return IntStream.range(1, racingOption.getNumberOfRounds())
                .mapToObj(x -> racingTrack.start())
                .collect(Collectors.toList());
    }
}
