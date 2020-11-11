package racingcar.controller;

import racingcar.dto.RaceReadyValue;
import racingcar.dto.RaceResultValue;
import racingcar.view.InputChannel;
import racingcar.view.InputView;
import racingcar.view.OuputChannel;
import racingcar.view.ResultView;
import racingcar.domain.RandomMove;
import racingcar.service.RacingCarService;

public class RacingCarApplication {

    public static void main(String[] args) {
        RaceReadyValue raceReadyValue = InputView.input(new InputChannel());

        RaceResultValue raceResultValue = RacingCarService.play(raceReadyValue, new RandomMove());

        ResultView.output(new OuputChannel(), raceResultValue);
    }
}
